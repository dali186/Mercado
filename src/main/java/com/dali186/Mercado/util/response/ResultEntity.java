package com.dali186.Mercado.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResultEntity<T> {
    private boolean success;
    private T data;
    private String message;

    public static <T> ResultEntity<T> success(T data, String message) {
        return new ResultEntity<>(true, data, message);
    }

    public static <T> ResultEntity<T> error(String message) {
        return new ResultEntity<>(false, null, message);
    }
}

