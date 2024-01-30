package com.example.taskmanager.tasks;

import com.example.taskmanager.ModelBase.ModelBase;
import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.UUID;

@Entity
@SQLDelete(sql = "UPDATE Task SET deleted = true WHERE task_id=?")
@Where(clause = "deleted = false")
public class Task extends ModelBase {

    @Id
    @GeneratedValue
    private Long taskId;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = true, length = 2000)
    private String description;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
    @JoinTable(name = "task_category",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;

    public Task(UUID uuid) {
        super(uuid);
    }

    public Task(String name, String description, List<Category> categories, Status status, UUID uuid) {
        super(uuid);
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.status = status;
    }

    public Task() {

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}