package com.example.taskmanager.status;

import com.example.taskmanager.Generics.ModelBase;
import lombok.Data;

@Data
public class State extends ModelBase {

    public State(String uuid, String name, String description, boolean deleted){
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        super.setDeleted(deleted);
    }
    public State() {}
}
