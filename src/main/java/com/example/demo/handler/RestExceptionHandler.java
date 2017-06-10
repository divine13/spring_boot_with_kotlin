package com.example.demo.handler;

import com.example.demo.dto.error.ErrorDetail;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by divine on 2017/06/04.
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResponseNotFoundException(ResourceNotFoundException rnfe,
                                                                            HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date().getTime(),
                                                  HttpStatus.NOT_FOUND.value(), "Resource not found",
                                                  rnfe.getMessage(), rnfe.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }
}
