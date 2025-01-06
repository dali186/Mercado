package com.dali186.Mercado.util.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResultEntity<T> {
	private String resultMsg;
	private T resultData;
	private HttpStatus httpStatus;
	
	public static <T> ResultEntity<T> success(T data, String msg) {
		return new ResultEntity<>(msg, data, HttpStatus.OK); 
	}
	
	public static <T> ResultEntity<T> error(T data, String msg) {
		return new ResultEntity<>(msg, data, HttpStatus.HTTP_VERSION_NOT_SUPPORTED); 
	} 
}
