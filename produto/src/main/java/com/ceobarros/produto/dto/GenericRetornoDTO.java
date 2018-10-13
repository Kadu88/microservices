package com.ceobarros.produto.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class GenericRetornoDTO<T> implements Serializable {

    private static final long serialVersionUID = -6130366456742087152L;

    private T body;
    private int httpStatus;

    public GenericRetornoDTO() {
    }

    public GenericRetornoDTO(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public GenericRetornoDTO(T body, int httpStatus) {
        this.body = body;
        this.httpStatus = httpStatus;
    }

    public T getBody() {
        return body;
    }

    public T getBody(Class<T> toValueType) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(body, toValueType);
    }

    public T getBody(TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(body, typeReference);
    }

    public void setBody(T body) {
        this.body = body;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

}

