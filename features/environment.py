# file: features/environment.py
# ----------------------------------------------------------------------------
# ENVIRONMENT: Hace configuraciones generales para todos los Features,
# Scenarios o Steps (dependiendo del nombre de la función), todas estas
# se llaman automáticamente.
# ----------------------------------------------------------------------------
import behave
import sys, os
from datetime import datetime
from behave.model_core import Status

# append a la carpeta raiz del proyecto para hacer los imports de los modulos desarrollados 
root_path = os.path.abspath(os.path.join(__file__, '../../'))
sys.path.append(root_path)
import Core.Excel as EM
import Core.Logging as LG
from Core.Selenium import Selenium

# rutas a las carpetas necesarias
data_path = str(root_path) + '/TestData/'
results_path = str(root_path) + '/Test Results/'
'''
# obtener variable username, si no está seteada desde el comando, se leerá de las variables de ambiente, sino, da error
def get_env_variable(context, var):
    # obtención de la variable desde el contexto o la linea de comandos
    var_value = None
    if context.config.userdata.get(var) is not None:
        var_value = context.config.userdata.get(var)
    else:
        if os.getenv(var) is not None:
            var_value = os.getenv(var)
        else:
            error_msg = '\n' + \
            '------------------------------------------------------------------------\n' + \
            'No existe la variable de entorno "' + var + '".\n' + \
            'Debe agregar "--define ' + var + '=<' + var + '>"\n' + \
            'al comando para poder ejecutar las pruebas sin dicha variable de entorno.\n' + \
            '-------------------------------------------------------------------------\n'
            raise Exception(error_msg)

    # agregación de las variables dentro de la variable de entorno a un diccionario
    value_dict = {}
    for key_value_pair in var_value.split(';'):
        k_v_p = key_value_pair.split('=')
        if len(k_v_p) !=2:
            error_msg = '\n' + \
            '--------------------------------------------------------------------------\n' + \
            'El valor de la variable "' + var + '" no tiene el formato requerido \n' + \
            '(conjunto de key-value pairs de la manera "key=value" separados por ";"). \n' + \
            'Por ejemplo: key1=value1; key2=value2\n' + \
            '---------------------------------------------------------------------------\n'
            raise Exception(error_msg)
        value_dict[str(k_v_p[0]).strip()] = str(k_v_p[1]).strip()
    return value_dict
'''

# antes de la ejecución de el programa completo
def before_all(context):
    # configuración del modo de ejecución de pruebas
    context.browser = Selenium()
    conf = context.config.userdata.get("conf")
    context.configs = context.browser.browserConfiguration(conf)

    # obtención de variables de ambiente
    #context.credentials = get_env_variable(context, 'credentials')
    #context.postgressql = get_env_variable(context, 'postgressql')

    # obtiene la cuenta de los features que no hacen match con las etiquetas a ejecutar
    context.unmatched_features = 0
    try:
        for f in context._runner.features:
            if f.should_run_with_tags(context.config.tag_expression) is False:
                context.unmatched_features += 1
    except: pass

    # configuración de behave
    # no muestra el resultado de los logging en pantalla y captura las salidas para agregarlas al log de error
    context.config.log_capture = False
    context.config.stdout_capture = True

    # creacion de la carpeta de Resultados si no existe
    try: os.stat(results_path)
    except: os.mkdir(results_path)

    # creación de las carpetas de resultados de ejecución
    exec_time = datetime.now()
    context.logs_path = results_path + str(exec_time.day) + '-' + str(exec_time.month) + \
                        '-' + str(exec_time.year) + '_' + str(exec_time.hour) + '-' + \
                        str(exec_time.minute) + '/'
    context.exec_dir_created = False

    # ruta de la carpeta de screenshots cuando hay errores
    context.ss_path = context.logs_path + '/Screenshots/'

    # array con las OA generadas
    context.oa_list = []


# después de la ejecución de el programa completo
def after_all(context):
    # resumen de los features, scenarios, steps y duracion
    hoy = datetime.now()
    hoy = str(hoy.day) + '-' + str(hoy.month) + '-' + str(hoy.year) + ' ' + \
          str(hoy.hour) + ':' + str(hoy.minute)
    feature_summary = context.config.reporters[-1].feature_summary
    try: 
        feature_summary['passed'] = feature_summary['passed'] - context.unmatched_features
        feature_summary['skipped'] = feature_summary['skipped'] + context.unmatched_features
    except: pass
    scenario_summary = context.config.reporters[-1].scenario_summary
    step_summary = context.config.reporters[-1].step_summary
    duration = context.config.reporters[-1].duration
    failed_scenarios = ''

    # conjunto de escenarios fallidos
    if len(context.config.reporters[-1].failed_scenarios) != 0:
        failed_scenarios = 'Failing scenarios:\n'
        for fail in context.config.reporters[-1].failed_scenarios:
            try: modulo = fail.tags[0].split('.')[0] + ': '
            except: modulo = ''
            failed_scenarios = failed_scenarios + '- ' + modulo + fail.feature.name + \
                                   '.feature    ' + fail.name + '\n'
        failed_scenarios = failed_scenarios + '\n\n\n'

    summary = '______________ SUMMARY - ' + hoy + ' ______________\n\n' + \
              str(feature_summary['passed']) + ' features passed, ' + \
              str(feature_summary['failed']) + ' failed' + ', ' + \
              str(feature_summary['skipped']) + ' skipped\n' + \
              str(scenario_summary['passed']) + ' scenarios passed, ' + \
              str(scenario_summary['failed']) + ' failed' + ', ' + \
              str(scenario_summary['skipped']) + ' skipped\n' + \
              str(step_summary['passed']) + ' steps passed, ' + \
              str(step_summary['failed']) + ' failed' + ', ' + \
              str(scenario_summary['skipped']) + ' skipped\n' + \
              'Time spent: ' + str(int(duration/60)) + 'm ' + str("%.2f" % (duration % 60)) + 's'

    print('\n\n********************Real Statistics********************\n')
    print(summary)
    print('\n*******************************************************\n\n')

    summary += '\n\n' + failed_scenarios

    # agregación de los números de OA generados por cada escenario
    if len(context.oa_list) > 0:
        oas = ''
        for oa in context.oa_list:
            oas += '>' + oa
        summary += 'Números de OA Generados por cada escenario:\n' + oas

    # escritura del summary al file de SUMMARY
    try:
        summary_file = context.logs_path + 'SUMMARY_RESULTS_' + context.configs[0] + '.txt'
        file = open(summary_file, "w+")
        file.write(summary)
    except: pass

    try: context.browser.closeBrowser(printer=False)
    except: pass


# antes de que un archivo feature se ejecute
def before_feature(context, feature):
    try: context.browser.driver.session_id
    except: context.browser.launchBrowser(context.configs[0], context.configs[1])
    feature.exec_time = datetime.now()

    # nombre base del log del feature, toma como nombre de base la descripción,
    # pero si no hay descripción agarra el nombre del primer scenario
    if len(feature.description) > 0:
        feature.log_name = feature.description[0]
    else:
        feature.log_name = feature.scenarios[0].name

    for s in feature.scenarios:
        feature.name_with_tag = list(s.tags)[0] + ' - ' + feature.name

        # lectura del archivo excel en caso de que el escenario sea de tipo Outline
        if type(s) == behave.model.ScenarioOutline:
            for exs in s.examples:
                if exs.table is None:
                    file_name = exs.name.split('|')
                    if len(file_name) == 1:
                        exs.table = EM.getTable(behave, data_path + file_name[0])
                        context.feature.excel=data_path + file_name[0]
                    elif len(file_name) == 2:
                        exs.table = EM.getTable(behave, data_path + file_name[0].strip(), file_name[1].strip())
                        context.feature.excel=data_path + file_name[0].strip()
                        context.feature.hoja_excel= file_name[1].strip()
                    else:
                        raise Exception('El nombre de archivo excel en Examples es incorrecto: ' + file_name)


# antes de que un escenario del feature se ejecute
def before_scenario(context, scenario):
    context.feature.name_with_scenario = scenario.name + ' - ' + context.feature.name
    # banderas
    context.flag1 = True
    context.flag2 = True
    # setea la variable de scenario actual al context
    context.scenario = scenario

    # setea el numero del row del escenario (cuando es de tipo Outline)#
    # (Útil cuando se quieren ingresar datos al excel desde las pruebas)
    try: context.row_index = scenario._row.index - 1
    except: pass


# después de que un escenario del feature se ejecute
def after_scenario(context, scenario):
    # marcar scenario como pasado si fue skipped a proposito
    try:
        if context.scenario.skipped_on_purpose is True:
            context.scenario.set_status(Status.passed)
    except: pass

    if scenario.status == 'failed':
        # agregacion de los pasos no ejecutados al log de errores
        for step in scenario.steps:
            if step.status.name != 'passed' and step.status.name != 'failed':
                try: LG.error(context.feature.logger, step.name + ' - ' + step.status.name)
                except: pass


# después de que un paso en un escenario se ejecute
def after_step(context, step):
    # creación de la carpeta de resultados de ejecución si no existe
    if context.exec_dir_created is False:
        context.exec_dir_created = True
        try: os.stat(context.logs_path)
        except: os.mkdir(context.logs_path)

    # agregacion del nombre de escenario al log
    if context.flag1 is True:
        context.flag1 = False
        try: LG.info(context.feature.logger, '\n\n' + context.feature.name_with_scenario + '\n')
        except:
            context.feature.logger = LG.createLogFile(context.logs_path, context.feature.exec_time,
                                                      context.feature.log_name)
            LG.info(context.feature.logger, '\n\n' + context.feature.name_with_scenario + '\n')
   
    try: 
        if context.flagEvidencia is True:
            # creación de la carpeta de Screenshots de la ejecución, en caso que no exista
            try: os.stat(context.ss_path)
            except: os.mkdir(context.ss_path)
            context.flagEvidencia = False
            now = datetime.now()
            ss_name = 'Evidencia_' + context.feature.logger.file_name + '-' + str(now.minute) + \
                    '_' + str(now.second) + '.png'
            context.browser.driver.save_screenshot(context.ss_path + '/' + ss_name)
    except:pass

    if step.status == "failed":
        # lectura de los prints capturados
        prints = 'Incompleto'
        if context.stdout_capture is not None:
            context.stdout_capture.seek(0)
            prints = '-' + str(context.stdout_capture.read()).replace('\n\n', '\n').replace('\n', '\n-')

        # creación de la carpeta de Screenshots de la ejecución, en caso que no exista
        try: os.stat(context.ss_path)
        except: os.mkdir(context.ss_path)

        # toma de Screenshot de la pantalla
        if context.flag2 is True:
            context.flag2 = False
            try:
                now = datetime.now()
                ss_name = 'Error_' + context.feature.logger.file_name + '-' + str(now.minute) + \
                          '_' + str(now.second) + '.png'
                context.browser.driver.save_screenshot(context.ss_path + '/' + ss_name)
                prints += 'Captura: ' + ss_name + '\n'
            except Exception as e:
                print('No se pudo tomar captura de pantalla.', e)

        # agregacion de los prints a la bitácora del feature (si no existe, lo crea)
        try: LG.error(context.feature.logger, step.name, str(prints))
        except:
            context.feature.logger = LG.createLogFile(context.logs_path, context.feature.exec_time,
                                                      context.feature.log_name)
            LG.error(context.feature.logger, step.name, str(prints))
    else:
        # agregacion del paso exitoso a la bitácora del feature (si no existe, lo crea)
        try: LG.info(context.feature.logger, step.name)
        except:
            context.feature.logger = LG.createLogFile(context.logs_path, context.feature.exec_time, 
                                                        context.feature.log_name)
            LG.info(context.feature.logger, step.name)
