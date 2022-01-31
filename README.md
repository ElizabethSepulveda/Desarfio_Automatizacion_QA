# Desafío_Automatización_QA

## La estructura de carpetas contienen  📦

- `driver\`: contiene el chromedriver para windows.
- `src`: contiene las carpetas java, test, REPORT, DATA.
- `REPORT`: contiene las reportes generados por las ejecuciones.
- `DATA\config.properties`: contiene datos para creación de usuario en la automatización.
- `java\pages`: contiene las pages.
- `java\runner`: contiene el o los ejecutores.
- `java\steps`: contiene las definiciones de los pasos.
- `resources\features`: contiene los features escritos en Cucumber y Gherkin.

## Documentación 📖

El estandar de documentación usado es Javadoc.

## Liberías externas  🛠️

El proyecto de automatización hace uso de liberías extenas para su correcto funcionamiento, las cuales se descargan mediante Gradle.

- name: 'selenium-java', version: '4.1.1'
- name: 'cucumber-java', version: '7.2.3'
- name: 'cucumber-junit', version: '7.2.3'
- name: 'junit-jupiter-api', version: '5.8.2'
- name: 'slf4j-simple', version: '1.7.33'
- name: 'extentreports-cucumber7-adapter', version: '1.2.0'
- name: 'cucumber-extentsreport', version: '3.1.1'

## Prerequisitos 📋

Se debe tener instalado en el equipo lo siguiente

- JDK 11.
- Gradle 7.3.3
- Chromedriver en la versión adecuada para el navegador y Sistema operativo. Se debe reemplazar en la carpeta driver.
  
## Ejecución ⚙️

Se debe ejecutar el siguiente comando en la carpeta raíz del proyecto para correr las pruebas de automatización.

    gradle clean
    gradle build

Para correr las pruebas especificas por tags "@" se debe ejecutar el siguiente comando.

    gradle test -D cucumber.options="tags @Compra"

## Revisión de Reportes 📄

Se generan dos reportes en formato HTML, los cuales quedan almacenados en la carpeta de ejecución correspondiente. Cada reporte tiene la información del paso a paso de la ejecución y la evidencia en capturas de pantallas, las cuales estan incrustadas en el HTML para evitar una posible modificación o alteración del reporte.

## Detalle del Flujo

### Flujo de Compra normal

* Ingresar a [opencart.abstracta.us](http://opencart.abstracta.us/index.php?route=common/home)
* Añadir al carro de compras un Ipod Classic
* Añadir al carro de compras un Imac
* Proceder a realizar la compra
* Realizar login con credenciales obtenidas de un archivo externo a elección (Basta que sea un email con estructura válida y contraseña)
* Crear una cuenta
* Continuar con la compra y llegar a la orden completa
* Visitar el historial de órdenes y validar resumen de orden 
* Cerrar sesión

### Flujo de Compra Apple Cinema
  - "Comprar un monitor Apple Cinema 30'' con las siguientes opciones disponibles:
    - Radio = Large (+30.00)
    - Checkbox múltiple = 2 (+20.00) y 4 (+40.00)
    - Texto = Test_1
    - Select = Yellow (+2.00)
    - TextArea = Data de prueba
    - Archivo = Subir archivo .jpg o .png a elección
    - Fecha = Calendario -> 2022-01-26
    - Tiempo = Reloj -> 17:25
    - Fecha y reloj = Calendario y reloj -> 2021-12-24 23:55
    - Cantidad = 2"