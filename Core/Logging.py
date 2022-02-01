# file: Core/Loggin.py
# ----------------------------------------------------------------------------
# MODULE: Crea los archivos .log
# ----------------------------------------------------------------------------

import logging


# genera el archivo log ERROR o INFO para un caso de prueba
def createLogFile(path, tiempo_actual, caso_prueba):
    file_name = caso_prueba + '_' + str(tiempo_actual.hour) + '-' + \
                str(tiempo_actual.minute) + '-' + str(tiempo_actual.second)

    formatter = logging.Formatter('%(asctime)s : %(levelname)s -: %(message)s')
    handler = logging.FileHandler(path + file_name + '.log')
    handler.setFormatter(formatter)
    logger = logging.getLogger(file_name)
    logger.setLevel(logging.INFO)
    logger.addHandler(handler)

    # atributos custom del logger
    logger.file_name = file_name
    return logger


# agrega un error al log recibido
def error(logger, log_txt, descripcion=None):
    if descripcion is None:
        descripcion = ''
    else:
        descripcion = '\n' + descripcion
    logger.error(log_txt + descripcion)


# agrega info al log recibido
def info(logger, log_txt):
    logger.info(log_txt)


# agrega un warning al log recibido
def warning(logger, log_txt):
    logger.warning(log_txt)


def Logging():
    return logging
