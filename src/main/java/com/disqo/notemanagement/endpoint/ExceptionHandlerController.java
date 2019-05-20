package com.disqo.notemanagement.endpoint;

import com.fasterxml.jackson.core.JsonParseException;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIOException(IllegalArgumentException ex) {
		LogManager.getLogger(getClass()).error(ex::getMessage, ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleIOException(Exception ex) {
		LogManager.getLogger(getClass()).error(ex::getMessage, ex);
		return new ResponseEntity<>("Something gone wrong!", HttpStatus.INTERNAL_SERVER_ERROR);//TODO @Davit, client should not receive
	}

	@ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
	public ResponseEntity<String> handleResourceMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {
		LogManager.getLogger(getClass()).error(ex::getMessage, ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({HttpMessageNotReadableException.class})
	public ResponseEntity<String> handleHttpMessageNotReadableException(JsonParseException ex) {
		LogManager.getLogger(getClass()).error(ex::getMessage, ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
