# Walmart challenge BackEnd - By Fernando Muñoz

Esta es la parte backend del Walmart challenge, está programada con Java
usando Spring Framework con SpringBoot

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
