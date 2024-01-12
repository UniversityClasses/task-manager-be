package com.example.taskmanager.exceptions;

public class CategoryNotFoundExeption extends RuntimeException {

    public CategoryNotFoundExeption() {
        super();
    }

    public CategoryNotFoundExeption(String message) {
        super(message);
    }

    public CategoryNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
