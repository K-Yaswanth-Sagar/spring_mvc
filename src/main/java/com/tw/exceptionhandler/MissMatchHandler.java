package com.tw.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MissMatchHandler {

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public String missMatchHandler(MethodArgumentTypeMismatchException e) {
		return "misMatch";
	}
	
}
