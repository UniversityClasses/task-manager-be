package com.example.taskmanager.exceptions;

public class CategoryNotFoundException extends CategoryManagerEntityNotFoundException {
    public CategoryNotFoundException(String uuids) {
        super("Category", uuids);
    }
}
