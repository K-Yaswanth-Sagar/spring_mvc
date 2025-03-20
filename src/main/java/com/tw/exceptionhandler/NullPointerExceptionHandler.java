package com.tw.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NullPointerExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullHandler(NullPointerException e) {
		return "nullexception";
	}
	
}
