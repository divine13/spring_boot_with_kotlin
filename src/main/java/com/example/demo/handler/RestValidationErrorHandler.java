package com.example.demo.handler;

import com.example.demo.dto.error.ValidationErrorDetail;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by divine on 2017/06/05.
 */
//@RestControllerAdvice
public class RestValidationErrorHandler {
//    public ResponseEntity<?> handleValidationError (
//            MethodArgumentNotValidException manve, HttpServletRequest request) {
//
//        ValidationErrorDetail validationErrorDetail = new ValidationErrorDetail();
//        validationErrorDetail.setTimeStamp(new Date().getTime());
//        validationErrorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
//        String requestPath = (String) request.getAttribute("javax.servlet.error.request_uri");
//        if(requestPath == null ) {
//            requestPath = request.getRequestURI();
//        }
//        validationErrorDetail.setTitle("validation failed");
//        validationErrorDetail.setDetail("input validation failed");
//        validationErrorDetail.setDeveloperMessage(manve.getClass().getName());
//
//
//        Iterable<? extends FieldError> fieldErrors = manve.getBindingResult().getFieldErrors();
//        for (FieldError fe : fieldErrors) {
//            List<ValidationErrorDetail> validationErrorDetails =
//                    validationErrorDetail
//                            .getErrors()
//                            .computeIfAbsent(fe.getField(), k -> new ArrayList<ValidationErrorDetail>());
//        }
//        return new ResponseEntity<Object>()
//    }
}
