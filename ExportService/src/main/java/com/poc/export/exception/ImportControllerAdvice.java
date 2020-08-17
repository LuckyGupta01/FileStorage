package com.poc.export.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static java.util.Collections.singletonList;

@ControllerAdvice(basePackages = { "com.example.demo" })
public class ImportControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = MyFileNotFoundException.class)
	ResponseEntity<Object> handleBadRequest(MyFileNotFoundException exception, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ApiError apiError = createApiError(exception);
		return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
	}

	private static ApiError createApiError(MyFileNotFoundException exception) {
		return new ApiError(singletonList(new ErrorMessage("Invalid File Id", exception.getMessage())));

	}
}
