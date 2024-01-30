package com.example.taskmanager.category;

import com.example.taskmanager.ModelBase.ModelBase;
import com.example.taskmanager.tasks.Task;
import jakarta.persistence.*;
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
@Entity
@SQLDelete(sql = "UPDATE Category SET deleted = true WHERE category_id=?")
@Where(clause = "deleted = false")
public class Category extends ModelBase {
    @Id
    @GeneratedValue
    private Long categoryId;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = true, length = 2000)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Task> tasks = new HashSet<>();

    public Category() {
    }

    public Category(UUID uuid) {
        super(uuid);
    }

    public Category(UUID uuid, String name, String description) {
        super(uuid);
        this.name = name;
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

}
