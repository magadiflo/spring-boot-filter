package com.magadiflo.filter.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class TestController {

    @GetMapping(value = "/test-filter")
    public ResponseEntity<?> getTest() {
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info(">>>>> Ejecutando método handler getTest()...");
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Pasaron los filtros exitosamente!!!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}