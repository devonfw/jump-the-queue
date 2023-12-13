# BACKEND-END DOCKERFILE JTQ
# /java directory

# PRIMERA IMAGEN - Building stage

# Creamos una capa a partir de una imagen base de cualquier version de Java
# que se encuentra localmente o en cualquier registro de contenedor
# FROM openjdk:11
# FROM maven:3.8.1-jdk-11-slim AS build-step
FROM maven:3.9.1-eclipse-temurin-11 AS build-step

# Situamos el directorio de trabajo dentro de la imagen del contenedor
# RUN mkdir -p /app
WORKDIR /app

# Creamos un espacio específico para persistir (almacenar) algunos datos en nuestro contenedor
# VOLUME /app/data

# Llega a ser necesario esto? Sí, y con el .dockerfile!
# COPY ocurre de fuera del container a dentro, es decir: Host (fuera) -> container /app (excepto lo de .dockerignore)
COPY . .
RUN mvn clean install
# RUN se ejecuta dentro del container y el resultado se produce dentro del mismo

 
# ALTERNATIVA A COMO HICIMOS LA COPIA EN EL FRONTEND
# Definimos una variable que se puede pasar a la app en tiempo de ejecución.
# En este caso, pasamos la ubicación del archivo .war final de nuestra app ubicado en la carpeta target/
# y lo guardamos en la variable JAR_FILE
#ARG JAR_FILE=server/target/jtqj-server-bootified.war

# Copiamos los nuevos archivos, directorios o URL de archivos remotos (server) desde la fuente y los agregamos
# al sistema de archivos de la imagen Docker en la ruta que proporcionemos. 
# En nuestro caso, agregamos la app de Spring Boot a la imagen de Docker desde la ruta de origen (var JAR_FILE) 
# a un destino que en el work directory app/ que llamamos jtqj-backend.jar
#ADD ${JAR_FILE} /app/app.jar


# COMO CON LA IMAGEN DEL FRONTEND
# Copy the JAR file into the container at /app
# COPY server/target/jtqj-server-bootified.jar /app/jtq-backend.jar


############################

# SEGUNDA IMAGEN (nuevo sistema de ficheros) - Production stage
# para correr la aplicacion que hemos buildeado en un servidor web (eclipse-temurin en este caso)

# Cambiamos la imagen para que el container derive de Eclipse-Temurin
# FROM tomcat:10.1-jdk11-openjdk-slim
FROM eclipse-temurin:11-jdk-alpine AS production-step
# Nos fijamos en que no tenga ningun puerto expuesto por defecto en docker.hub.com

# me traigo del la 1a imagen el .war generado, lo unico que me interesa
# para tomcat hay que dejarlo en ese directorio, sacarlo en google -> docker tomcat 11
# COPY --from=build-step /app/server/target/jtqj-server-bootified.war /usr/local/tomcat/webapps/ROOT.war
COPY --from=build-step /app/server/target/jtqj-server-bootified.war .

# La app está escuchando en el puerto 8081 segun el archivo application.properties del repo (core/resources...)
EXPOSE 8081

# Especificamoms el comando que Docker utilizará para ejecutar nuestra aplicación
# En este caso, pasamos el comando común para ejecutar un archivo jar: java -jar <nombre del archivo jar>
ENTRYPOINT ["java", "-jar", "jtqj-server-bootified.war"]
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# misma funcion que instrucción ENTRYPOINT no? No, ENTRYPOINT fuerza y no se puede reemplazar desde la cli
