package com.example.taskmanager.tasks;

import com.example.taskmanager.Generics.ModelBase;
import com.example.taskmanager.categories.Category;
import com.example.taskmanager.status.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE Task SET deleted = true WHERE id=?")
@EnableJpaAuditing
@EqualsAndHashCode(callSuper = false)
@Where(clause = "deleted = false")
public class Task extends ModelBase {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "task_category",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonManagedReference
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", nullable = true)
    @JsonManagedReference
    private State status;

    public Task(){}
    public Task(UUID uuid) {
       super.setUuid(uuid);
    }

    public Task(String name, String description, List<Category> categories, State status, UUID uuid) {
        super.setName(name);
        super.setDescription(description);
        this.categories = categories;
        this.status = status;
        super.setUuid(uuid);
    }
}
