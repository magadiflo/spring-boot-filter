# Instrucciones

EN POSTMAN, para ejecutar en postman debemos mandar el username: user y el password que nos proporciona spring boot en
la consola (Siempre y cuando no se haya configurado un user y pass en el application.properties)

``` 
url: http://localhost:8080/test-filter
Authorization: Basic Auth
Username: user
Password: la de la consola
```

# Conclusión:

Al llamar al método getTest() desde la url /test-filter, se ejecutará primero los filtros, dependiendo del orden en el
que se hayan configurado. Si pasan todos los filtros, es solo en ese momento que el método handler getTests() mapeado a
la uri /test-filter que será ejecutado.

# Referencias

Tomado de: https://www.youtube.com/watch?v=3Y21aq-6_OE <br>
Referencia consultada: https://www.javadevjournal.com/spring-boot/spring-boot-add-filter/