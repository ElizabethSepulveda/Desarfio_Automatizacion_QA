# Desafío_Automatización_QA

### Environment Setup
- Instalar JDK 8
- Instalar Maven

Asegurese de configurar las variables de entorno en su equipo, configuración asociada a Maven y Java

### Runnig Test

```
$ mvn integration-test -Drunner="*Runner" -Dcucumber.options="--tags @run"
```
Usar el comando para ejecutar las pruebas, puede usar el tag dispuesto en cada caso de prueba, marcado en en los archivos .feature, por ejemplo @run

```
$ mvn clean install
```
Es posible usar el comando por defecto de maven para ejecutar las pruebas

- Nota: Asegurese que al momento de ejecutar los comandos, sean en el directorio principal, por ejemplo: \Projects\Desafio_Automatizacion_QA, la carpeta Desafio_Automatizacion_QA contiene el directorio src, .pom 


### Resources

- No se requiere de instalación de chromedriver, el proyecto contiene un driver manager que automatiza la descarga y puesta en marcha del webdriver

- En el directorio feature, se encuentre los archivo con sintaxis gherkins para su detalle de flujo.

- Se dispone el siguiente directorio para los data read provider: src/test/java/cl/test/dataResource/data

- Para crear nueva cuenta, se debe cambiar el dato del parametro emailNew en el archivo registerUser.properties para que no genere conflictos de datos y se interrumpa el flujo de prueba

- Cuando ejecute los test, se genera varios directorios de salida a continuación: target

- Dentro del directorio anterior se encuentra los recursos de salida (reporte -> target/generated-report), (log ->target/failsafe-reports)