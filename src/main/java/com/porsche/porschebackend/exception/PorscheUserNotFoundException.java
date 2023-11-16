package com.porsche.porschebackend.exception;

public class PorscheUserNotFoundException extends RuntimeException {
    public PorscheUserNotFoundException(Long id) {
        super("User not found for id: " + id);
    }
}
