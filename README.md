# REST API cabeceras

Esta es una aplicacion cuyo objetivo es regresar los headers que se envian en una peticion a un microservicio
obteniendo como respuesta un mapa Map<String, List<String>> donde el key  del mapa es el nombre del header, 
y el value es una lista de Strings con todos los valores para el respectivo header.

Adicional, contiene otro  m�todo para regresar el mismo objeto Map<String, List<String>> pero filtrado con solo los headers que se indican mediante una lista 
de Strings

## Pre-requisitos

* [Git] (https://git-scm.com/downloads) - Control de versiones
* [Java 8](https://www.oracle.com/mx/java/technologies/javase/javase-jdk8-downloads.html) - SDK  de Java
* [Spring Tool Suite 4](https://spring.io/tools) - Entorno de desarrollo
* [Maven](https://maven.apache.org/) - Manejador de dependencias


## Instalaci�n


Descarga el codigo del siguiente repositorio con tu consola Git

```
git clone https://github.com/Carletto10/wipro-headers.git
```

Importa el proyecto al entorno de Spring tool suite 4-4.7.1.RELEASE

	

## Ejecutar la aplicacion

Click derecho al proyeto 'wipro' y click en Run as -> Spring Boot App

La aplicaci�n estara disponible en la siguiente URL : localhost:8080


# REST API

Los endpoints disponibles en la aplicacion se listan a continuacion.

## Obten encabezados de una peticion GET

### Request

`GET /getCabeceras/`

	curl -i -H 'Accept: application/json' http://localhost:8080/getCabeceras

### Response

	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 23 Nov 2020 20:22:06 GMT

	{"host":["localhost:8080"],"accept":["application/json"],"user-agent":["curl/7.69.1"]}


## Obten encabezados de una peticion POST filtrados por una lista dada

### Request

`POST /getCabecerasByLista/`

    curl -i -H "Content-Type: application/json" --request POST --data '["user-agent"]' http://localhost:8080/getCabecerasByLista

### Response

	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 23 Nov 2020 20:25:18 GMT

	{"user-agent":["curl/7.69.1"]}


