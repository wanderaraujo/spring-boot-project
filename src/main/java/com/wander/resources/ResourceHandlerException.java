package com.wander.resources;

import com.wander.exception.ObejectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceHandlerException {

    @ExceptionHandler(ObejectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObejectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found",e.getMessage(),request.getRequestURI() );
        return ResponseEntity.status(status).body(err);
    }

}
