# FileStorage

#############################################################

I have created couple of core micro services.

1. Import Service.
2. Export Service.

Rest Service Exposed.

REST API to import the tar files into store.(Part Of Import Service)
REST API to pull the tar file. (Part Of Export Service).
REST API to list the store files.(Part Of Export Service).

I have dockerized each of the microservice along with mysql container.

Please run the following commnds to run the project.

1 Package each microservice using 
  a) mvn clean package.
2 Run command docker-compose up to containerise the app with mysql instance.

I have configured Swagger documentation and can be accessed using swagger ui with following url.

{baseAddress}/api/importService/v1/swagger-ui.html.


############################################################




