package com.walmart.challenge.exception;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.walmart.challenge.domain.ErrorInfo;

public class ExceptionControllerAdviceTest {
	
    private ExceptionControllerAdvice exceptionControllerAdvice;
    private HttpServletRequest request;

    @Before
    public void before() {
        exceptionControllerAdvice = new ExceptionControllerAdvice();
        request = mock(HttpServletRequest.class);
        when(request.getRequestURL()).thenReturn(new StringBuffer("/url"));

    }

    @Test
    public void handleExceptionTest() {

        ErrorInfo errorInfo = exceptionControllerAdvice.handleException(request, new Exception("error inesperado"));
        Assert.assertNotNull(errorInfo);
        Assert.assertEquals("ERROR_GENERAL_APLICACION", errorInfo.getCode());
        Assert.assertEquals("error inesperado", errorInfo.getMessage());
        Assert.assertEquals("/url", errorInfo.getUrl());
    }

    @Test
    public void handleThrowableTest() {

        ErrorInfo errorInfo = exceptionControllerAdvice.handleThrowable(request, new Throwable("error inesperado"));
        Assert.assertNotNull(errorInfo);
        Assert.assertEquals("ERROR_GENERAL_APLICACION", errorInfo.getCode());
        Assert.assertEquals("error inesperado", errorInfo.getMessage());
        Assert.assertEquals("/url", errorInfo.getUrl());
    }

}
