package com.example.demoproweb.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BaseResponse<RESP_T> implements Serializable {
    private String code;
    private String message;
    private RESP_T data = null;

    private static String CODE_SUCCESS = "0";

    public static <T> BaseResponse<T> success() {
        return new BaseResponseBuilder<T>()
                .code(CODE_SUCCESS)
                .message("ok")
                .build();
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponseBuilder<T>()
                .code(CODE_SUCCESS)
                .message("ok")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> error(String code, String message) {
        return new BaseResponseBuilder<T>()
                .code(code)
                .message(message)
                .build();
    }
}
