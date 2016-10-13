package com.thoughtworks.gaia.common.exception;

import java.util.Map;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class NotFoundException extends BaseResponseException {
    public NotFoundException() {
        super(NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(NOT_FOUND, errorCode);
    }

    public NotFoundException(ErrorCode errorCode, Map<String, String> errorInfo) {
        super(NOT_FOUND, errorCode, errorInfo);
    }

    public NotFoundException(Map<String, String> errorInfo) {
        super(NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND, errorInfo);
    }
}
