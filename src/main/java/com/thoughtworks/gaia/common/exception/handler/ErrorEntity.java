package com.thoughtworks.gaia.common.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.common.exception.ErrorCode;

import java.util.HashMap;
import java.util.Map;

public final class ErrorEntity {
    private ErrorCode errorCode;
    private Map<String, String> errorInfo;
    private String message;

    public ErrorEntity() {
    }

    public ErrorEntity(final ErrorCode errorCode, final String message) {
        this(errorCode, new HashMap<>(), message);
    }

    public ErrorEntity(final ErrorCode errorCode, final Map<String, String> errorInfo, final String message) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
        this.message = message;
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new BadRequestException();
        }
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, String> getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(final Map<String, String> errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
