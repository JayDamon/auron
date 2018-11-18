package com.protean.security.auron.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

   private static final long serialVersionUID = 1L;

   @JsonProperty(value = "code")
   private Integer code;
   @JsonProperty(value = "status")
   private String status;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
