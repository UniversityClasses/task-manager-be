package com.example.taskmanager.categories;

import com.example.taskmanager.Generics.ModelBase;
import lombok.Data;

@Data
public class Category extends ModelBase {
    public Category(String uuid, String name, String description, boolean deleted){
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        super.setDeleted(deleted);
    }
    public Category() {}
    public Category(String name) {
        super.setName(name);
    }
}
