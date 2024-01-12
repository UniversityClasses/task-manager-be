package com.example.taskmanager.exceptions;

public class StateNotFoundExeption extends RuntimeException {

    public StateNotFoundExeption() {
        super();
    }

    public StateNotFoundExeption(String message) {
        super(message);
    }

    public StateNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public StateNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
