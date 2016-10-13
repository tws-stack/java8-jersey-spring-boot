package com.thoughtworks.gaia.common.exception;

import java.util.Map;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

public class BadRequestException extends BaseResponseException {
    public BadRequestException() {
        super(BAD_REQUEST);
    }

    public BadRequestException(ErrorCode errorCode) {
        super(BAD_REQUEST, errorCode);
    }

    public BadRequestException(ErrorCode errorCode, Map<String, String> errorMessages) {
        super(BAD_REQUEST, errorCode, errorMessages);
    }
}
