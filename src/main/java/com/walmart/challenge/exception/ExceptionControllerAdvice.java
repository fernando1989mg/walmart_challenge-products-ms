package com.walmart.challenge.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.walmart.challenge.domain.ErrorInfo;
import com.walmart.challenge.domain.Errors;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ErrorInfo handleException(HttpServletRequest req, Exception ex) {
        LOGGER.error(Errors.ERROR_GENERAL_APLICACION.getCode(), ex);
        return new ErrorInfo(req.getRequestURL().toString(), Errors.ERROR_GENERAL_APLICACION.getCode(), ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ErrorInfo handleThrowable(HttpServletRequest req, Throwable e) {
        LOGGER.error(Errors.ERROR_GENERAL_APLICACION.getCode(), e);
        return new ErrorInfo(req.getRequestURL().toString(), Errors.ERROR_GENERAL_APLICACION.getCode(), e.getLocalizedMessage());
    }
}
