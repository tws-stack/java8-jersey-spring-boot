package com.thoughtworks.gaia.common.exception;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseResponseException extends RuntimeException {
    private final Response.Status status;
    private final ErrorCode errorCode;
    private final Map<String, String> errorMessages;

    protected BaseResponseException(final Response.Status status) {
        this(status, ErrorCode.UNKNOWN, new HashMap<>());
    }

    protected BaseResponseException(final Response.Status status, ErrorCode errorCode) {
        this(status, errorCode, new HashMap<>());
    }

    protected BaseResponseException(final Response.Status status,
                                    final ErrorCode errorCode,
                                    final Map<String, String> errorMessages) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessages = errorMessages;
    }

    public final Response.Status getStatus() {
        return status;
    }

    public final ErrorCode getErrorCode() {
        return errorCode;
    }

    public final Map<String, String> getErrorMessages() {
        return errorMessages;
    }
}
