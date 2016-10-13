package com.thoughtworks.gaia.common.exception;

public enum ErrorCode {
    // 0 ~ 2000, system error
    UNKNOWN(0),
    RESOURCE_NOT_FOUND(1);

    private final int code;

    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
