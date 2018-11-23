package com.protean.security.auron.exception;

import com.protean.security.auron.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {AppException.class})
    protected ResponseEntity<?> handleAppException(AppException e, WebRequest request) {
        log.error(e.getMessage(), e);
        BaseResponse response = new BaseResponse();
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        response.setStatus(e.getMessage());
        return handleExceptionInternal(e, response, new HttpHeaders(), HttpStatus.UNAUTHORIZED,
                request);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<?> handleBadRequest(BadRequestException e, WebRequest request) {
        log.error("Bad Request, " + e, e);
        BaseResponse response = new BaseResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setStatus("Bad Request: " + e.getMessage());
        return handleExceptionInternal(e, response, new HttpHeaders(), HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException e, WebRequest request) {
        log.error("Resource not found, " + e, e);
        BaseResponse response = new BaseResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setStatus("Resource could not be found");
        return handleExceptionInternal(e, response, new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    protected ResponseEntity<?> handleUserNameNotFound(UsernameNotFoundException e, WebRequest request) {
        log.error("Username not found, " + e, e);
        BaseResponse response = new BaseResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setStatus("Username not found");
        return handleExceptionInternal(e, response, new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

}
