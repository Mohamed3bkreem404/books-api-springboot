package com.SpringData.DataProject.ExceptionHandleing;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception){
            Map<String , Object> errorBody = new HashMap<>();
            errorBody.put("TimeStamp", LocalDateTime.now());
            errorBody.put("Status", HttpStatus.BAD_REQUEST.value());


            Map<String,String> errors = new HashMap<>();
            exception.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                errors.put(fieldName,message);
            });
            errorBody.put("errors",errors);
            return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
        }
}
