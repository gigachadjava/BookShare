package com.bookshare.bookshare.exeptions;


import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        this("EntityRepresentationModel not found");
    }
    private final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    public HttpStatus getBadRequest() {
        return badRequest;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
