package com.example.demo.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

	private static final String PATH = "/custom-error";


    @RequestMapping(value = PATH)
    public ResponseEntity<String> error(HttpServletRequest request) {
        // Lógica para determinar el tipo de error y generar una respuesta personalizada
        return new ResponseEntity<>("Error personalizado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

   // @Override
    public String getErrorPath() {
        return PATH;
    }
}
