package com.ventas.ventas.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception e){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Ha ocurrido un error", e.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach( error -> {
			String fieldname = ((FieldError)error).getField();
			String mensajeDeError = error.getDefaultMessage();
			errores.put(fieldname, mensajeDeError);
		});
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Un error ha ocurrido", ex.getMessage(), errores);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
