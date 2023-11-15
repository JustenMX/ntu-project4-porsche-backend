package com.porsche.porschebackend.exception;

public class PorscheUserAuthNotFoundException extends RuntimeException {
    public PorscheUserAuthNotFoundException(Long id) {
        super("Auth user not found for id: " + id);
    }
}
