package com.example.taskmanager.status;

import com.example.taskmanager.ModelBase.ModelBase;
import com.example.taskmanager.tasks.Task;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
@SQLDelete(sql = "UPDATE Status SET deleted = true WHERE status_id=?")
@Where(clause = "deleted = false")
public class Status extends ModelBase {
    @Id
    @GeneratedValue
    private Long statusId;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = true, length = 2000)
    private String description;

    @OneToMany(mappedBy = "status", cascade = CascadeType.PERSIST)
    private List<Task> tasks;

    public Status() {
    }

    public Status(UUID uuid) {
        super(uuid);
    }

    public Status(UUID uuid, String name, String description) {
        super(uuid);
        this.name = name;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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


    @PrePersist
    public void initializeUuid() {
        this.setUuid(UUID.randomUUID());
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
