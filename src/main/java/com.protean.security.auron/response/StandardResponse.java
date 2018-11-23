package com.protean.security.auron.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * Generic response that takes any object in the data field
 * which Jackson will use to serialize into Json response
 *
 * @param <T> Any object that needs to be serialized as JSON by Jackson
 */

public class StandardResponse<T> extends BaseResponse {

    @JsonProperty(value = "data")
    private T data;

    public StandardResponse(HttpStatus httpStatus, T data) {
        this.setCode(httpStatus.value());
        this.setStatus(httpStatus.getReasonPhrase());
        this.data = data;
    }

    public StandardResponse(HttpStatus httpStatus, String status, T data) {
        this.setCode(httpStatus.value());
        this.setStatus(status);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
