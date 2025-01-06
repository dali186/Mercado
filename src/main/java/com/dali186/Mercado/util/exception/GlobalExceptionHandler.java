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
		ResultEntity<Void> response = ResultEntity.error(ResultCode.memberFindErr);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
