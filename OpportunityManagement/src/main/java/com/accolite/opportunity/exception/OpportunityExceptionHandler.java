package com.accolite.opportunity.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OpportunityExceptionHandler {
	@ExceptionHandler(value = OpportunityNotFoundException.class)
	public ResponseEntity<?> exception(OpportunityNotFoundException ex, WebRequest request) {
		 ErrorLogging errornotfound = new ErrorLogging(new Date(),"Opportunity Id not found", request.getDescription(false));
	      return new ResponseEntity<ErrorLogging>(errornotfound, HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler(value = OpportunityServiceErrorException.class)
	public ResponseEntity<?> exception(OpportunityServiceErrorException ex, WebRequest request) {
		 ErrorLogging servererror = new ErrorLogging(new Date(), "Server Error due to Empty Data Access", request.getDescription(false));
	      return new ResponseEntity<ErrorLogging>(servererror,  HttpStatus.INTERNAL_SERVER_ERROR);
	   }
}