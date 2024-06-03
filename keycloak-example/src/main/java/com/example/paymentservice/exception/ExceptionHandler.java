package com.example.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {



    public ResponseEntity<?> handleException(AnonymousAuthenticationToken token){
        Map<String,String>map = new HashMap<>();
        map.put("tokenValue",token.getCredentials().toString());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);

    }
}
