package com.example.taskmanager.status;


import com.example.taskmanager.modelbase.ModelBase;

import java.sql.Timestamp;

public class Status extends ModelBase {
    private String stateId;
    private String name;

    public Status(String uuid) {
        super(uuid);
    }

    public Status(String name, String uuid) {
        super(uuid);
        this.name = name;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
