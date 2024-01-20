package com.example.taskmanager.exceptions.categories;

import com.example.taskmanager.exceptions.tasks.TaskManagerEntityNotFoundException;

public class CategoryNotFoundException extends TaskManagerEntityNotFoundException {
    public CategoryNotFoundException(String uuids) {
        super("Category", uuids);
    }
}
