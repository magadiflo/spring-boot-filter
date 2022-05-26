package com.magadiflo.filter.app.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //******* 1° PROCESAR EL FILTRO
        //Realizamos lo que queremos procesar, en este caso solo estamos imprimiendo un log
        Logger logger = LoggerFactory.getLogger(MyFilter.class);
        //Debería imprimir: //>>>>> MyFilter...  GET : /test-filter
        logger.info(">>>>> MyFilter... request  {} : {}", request.getMethod(), request.getRequestURI());

        //******* 2° DECIDIR SI PASAMOS LA CADENA AL SIGUIENTE FILTRO O LO ABORTAMOS
        //filterChain: Cadena de filtros
        //Decidimos si pasamos la cadena al siguiente filtro o abortamos la petición.
        //En este caso, al llamar al filterChain.doFilter(request, response) estamos pasando la petición al siguiente filtro
        //Si decidiéramos no hacer ese filterChain.doFilter(request, response), estaríamos indicando que estamos rechazando
        //la petición y empezaría a rebotar hacía el cliente

        //Llama al siguiente filtro en la cadena de filtros
        filterChain.doFilter(request, response);

        //******* 3° VEMOS EL RETORNO DE LA RESPUESTA AL CLIENTE
        logger.info(">>>>> MyFilter... response: {}", response.getContentType());
    }

}
