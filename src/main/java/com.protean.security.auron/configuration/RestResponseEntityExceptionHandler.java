package com.protean.security.auron.configuration;

import com.protean.security.auron.entity.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {SecurityException.class})
    protected ResponseEntity<?> handleUnauthorizedUser(SecurityException e, WebRequest request) {
        log.error("Authorization failed, " + e, e);
        BaseResponse response = new BaseResponse();
        response.setCode(401);
        response.setStatus("unauthorized");
        return handleExceptionInternal(e, request, new HttpHeaders(), HttpStatus.UNAUTHORIZED,
                request);
    }

}
