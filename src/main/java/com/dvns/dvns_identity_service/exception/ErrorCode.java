package com.dvns.dvns_identity_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

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
@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Error !", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(1007, "You do not have permission !", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(1006, "Unauthenticated !", HttpStatus.UNAUTHORIZED),
    USER_NOT_EXISTED(1005, "User not existed !", HttpStatus.NOT_FOUND),
    ERROR_KEY_INVALID(1004, "Enum Key invalid !", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least 8 characters !", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1002, "Password must be at least 8 characters !", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1001, "User existed !", HttpStatus.BAD_REQUEST),
    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
