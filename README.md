# Prueba tecnica backend developer Accenture

Este proyecto es un backend desarrollado en **Spring Boot** el cual sirve como muestra de conocimientos para aplicar a la posicion de Backend developer en Accenture.

## Despliegue en la nube

La aplicación se subió a Azure Container Instances desplegando la imagen creada con Docker, asi mismo, se configuró un servicio de Azure Database for PostgreSQL para la base de datos.
El aplicativo es accesible mediante [esta ruta](http://jmlozano-test-accenture.g4dnf7c4f2gwgdb9.eastus2.azurecontainer.io:9090/api-test-accenture/swagger-ui/index.html).
Allí se visualizará el Swagger del aplicativo creado.

![image](https://github.com/user-attachments/assets/98268c3e-6216-4481-970f-1ed29b444610)

## Prerrequisitos para instalación local

Se requieren las siguientes herramientas para la ejecución local:

- [Java JDK 21 o superior](https://adoptopenjdk.net/)
- [Docker](https://www.docker.com/products/docker-desktop)

### Ejecución mediante Gradle (sin usar Docker)
1. Clonar el proyecto.
2. En la ruta raiz del proyecto, ejecutar './gradlew clean build'. Esto compilará el proyecto generando el ejecutable JAR.
3. Finalmente, ejecutar 'java -jar ./build/libs/app-test-accenture.jar'. La aplicación se ejecutará en el puerto 9090 y será accesible en la ruta [http://localhost:9090/api-test-accenture/swagger-ui.index.html](http://localhost:9090/api-test-accenture/swagger-ui.html)

### Ejecución mediante Docker
1. Clonar el proyecto.
2. En la ruta raiz del proyecto y teniendo docker instalado, ejecutar 'sudo docker build -t spring/app-test-accenture .'
   
![image](https://github.com/user-attachments/assets/b4b4c44e-82b9-4128-a9eb-0cabdf19ce39)
3. Por ultimo, ejecutar el comando para correr la imagen generada, 'sudo docker run -p 9090:9090 spring/app-test-accenture'

![image](https://github.com/user-attachments/assets/1245394e-3cd2-4faf-ad93-01c9e89a871b)
De igual forma, la aplicacion estará disponible en [esta ruta](http://localhost:9090/api-test-accenture/swagger-ui.html) usando el puerto 9090.

## Uso
Puede navegar a través de las distintas opciones en la interfaz de Swagger, sin la necesidad de configurar manualmente las peticiones en una herramienta como Postman.

![image](https://github.com/user-attachments/assets/a989061a-bb2a-4244-9a9e-366fea278661)

Para el desarrollo se usó programación funcional y se implementó una arquitectura limpia.
Espero sea de su agrado.
