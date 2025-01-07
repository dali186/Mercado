package com.dali186.Mercado.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dali186.Mercado.util.response.ResultCode;
import com.dali186.Mercado.util.response.ResultEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResultEntity<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
		ResultEntity<Void> response = ResultEntity.error(ResultCode.MEMBER_FIND_ERR);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler(ResourceDuplicatedException.class)
    public ResponseEntity<ResultEntity<Void>> handleResourceDuplicated(ResourceDuplicatedException ex) {
		ResultEntity<Void> response = ResultEntity.error(ResultCode.MEMBER_JOIN_ERR);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
	}
}
