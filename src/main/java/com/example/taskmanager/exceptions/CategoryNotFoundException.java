package com.example.taskmanager.exceptions;

public class CategoryNotFoundException extends TaskManagerEntityNotFoundException {
    public CategoryNotFoundException(String uuids) {
        super("Category", uuids);
    }
}
