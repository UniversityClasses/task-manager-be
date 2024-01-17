package com.example.taskmanager.status;

import com.example.taskmanager.Generics.ModelBase;
import com.example.taskmanager.tasks.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@SQLDelete(sql = "UPDATE State SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = false)
public class State extends ModelBase {

    @OneToMany(mappedBy = "status", cascade = CascadeType.PERSIST)
    private List<Task> tasks;

    public State() {
    }

    public State(UUID uuid) {
        super.setUuid(uuid);
    }

    public State(UUID uuid, String name, String description) {
        super.setUuid(uuid);
        super.setName(name);
        super.setDescription(description);
    }
}
