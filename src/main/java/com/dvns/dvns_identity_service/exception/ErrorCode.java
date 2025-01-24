package com.dvns.dvns_identity_service.exception;

/**
 * ErrorCode
 * <p>
 * Version 1.0
 * <p>
 * Date:  1/17/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 1/17/2025    NhanDinhVan    Create
 */

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception !"),
    USER_NOT_EXISTED(1005, "User not existed !"),
    ERROR_KEY_INVALID(1004, "Enum Key invalid !"),
    USERNAME_INVALID(1003, "Username must be at least 8 characters !"),
    PASSWORD_INVALID(1002, "Password must be at least 8 characters !"),
    USER_EXISTED(1001, "User existed !"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
