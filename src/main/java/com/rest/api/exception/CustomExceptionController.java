package com.rest.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ItemNotFoundException.class)
	   public ResponseEntity<Object> exception(ItemNotFoundException exception) {
	      return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
	   }

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorType error = new CustomErrorType("Server Error");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
