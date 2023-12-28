package com.bookshare.bookshare.exeptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiException(String message, HttpStatus httpStatus, Throwable throwable, ZonedDateTime zonedDateTime) {
}
