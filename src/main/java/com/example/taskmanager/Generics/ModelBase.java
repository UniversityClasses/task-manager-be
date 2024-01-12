package com.example.taskmanager.Generics;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class ModelBase {
    private String Id;
    private String name;
    private String description;
    private String uuid;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;
}
