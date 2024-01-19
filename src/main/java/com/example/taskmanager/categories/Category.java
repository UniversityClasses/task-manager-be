package com.example.taskmanager.categories;

import com.example.taskmanager.Generics.ModelBase;
import com.example.taskmanager.tasks.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//@NamedStoredProcedureQuery(
//        name = "get_category_by_id",
//        procedureName = "get_category_by_id",
//        resultClasses = Category.class,
//        parameters = {
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "categoryId", type = Long.class)
//        }
//)
@Data
@Entity
@SQLDelete(sql = "UPDATE Category SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = false)
public class Category extends ModelBase {

    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Task> tasks = new HashSet<>();
    public Category() {
    }

    public Category(UUID uuid) {
        super.setUuid(uuid);
    }

    public Category(UUID uuid, String name, String description) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
    }
    public Category(UUID uuid, String name, String description, Set<Task> tasks) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
        this.tasks = tasks;
    }
}
