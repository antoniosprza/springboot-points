## Requisitos

* Docker
* JDK 8
* Node.js
* Mvn (maven)
* PgAdmin

##Instrucciones


Descargar el proyecto springboot-points y producto_fullstack
### `git clone https://github.com/antoniosprza/producto_fullstack.git`
### `git clone https://github.com/antoniosprza/springboot-points.git`


Para generar la red donde se contendrán la base de datos y el servicio de Points
### `docker network create cloud`


Para generar la imagen de la base de datos ejecutar el Docker file en /src/cmain/BDPostgis de springboot-points (desde el directorio donde se descargaron los repositorios)
### `cd /src/main/BDPostgis`
### `docker build -t postgis12 .`


Y ejecutar la imagen
### `docker run --volume aLocalPath:/home/osmdata/gpkg --rm -P -p 55432:5432 -d --name postgis --network cloud  postgis12`


Crear el archivo jar del micro servicio springboot-points con maven (desde el directorio donde se descargo el repositorio)
### `mvn clean package -DskipTests=true`

Ejecutar el Dockerfile para generar la imagen para el micro servicio de /src
### `docker build -t springboot-points .`

Ejecutar la imagen
### `docker run -p 8080:8080 -d --name springboot-points --network cloud springboot-points`

Verificar que el servicio muestra el JSON correctamente desde
### `localhost:8080/api/points`

Por último se genera la imagen del front de React desde el directorio donde se descargo el proyecto producto_fullstack
### `docker build -t ps-container:dev .`

Ejecutar la imagen
### `docker run -it --rm -v ${PWD}:/app -v /app/node_modules -p 3000:3000 -d -e CHOKIDAR_USEPOLLING=true ps-container:dev`

Ingresar al portal de React
### `localhost:3000`
