# Walmart challenge BackEnd - By Fernando Muñoz

Esta es la parte backend del Walmart challenge, está programada con Java
usando Spring Framework con SpringBoot

## Cómo ver el proyecto en ejecución?

 - Está publicado en el siguiente link -> https://walmart-challenge.kawm.cl
 - La URL base de la API Rest es -> https://api.walmart-challenge.kawm.cl

## Cómo ejecutar el backend en local?

*   Descargando la imagen Docker alojada en Docker Hub:

    ```
    docker login
    docker pull fernando1989mg/walmart_challenge-products-ms:v2
    nohup docker run -p 3001:3001 fernando1989mg/walmart_challenge-products-ms:v2 &
    ```


*   También puede situarse en la raiz del proyecto y ejecutar el comando 

    ```
    mvn spring-boot:run
    ```

## Cómo funciona?

*   El microservicio solo expone dos endpoint:

    ```
    /products/health
    ```
    ```
    /products/search?q=adsda&page=0
    ```

*   El /health es simplemente para saber si el servicio está ejecutandose, esto lo ocupa AWS
*   Por otro lado el /search?q=adsda&page=0 sirve para hacer búsquedas los dos parámetros son por un lado "q" que recibe el texto a buscar
 y por otro lado "page" recibe el número de página a consultar
    
## Notas adicionales

La base de datos es MongoDB la cual está implementada en un cluster de MongoDB Atlas, por temas de tiempo y para algo demostrativo las 
credenciales están dentro del proyecto con un usuario de solo lectura, sin embargo lo óptimo sería dejar estas credenciales en un servicio
como Vault o AWS Secret Manager
