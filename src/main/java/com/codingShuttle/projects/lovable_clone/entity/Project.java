package com.codingShuttle.projects.lovable_clone.entity;

import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name="projects",
indexes={
        @Index(name=" idx_projects_updated_at_desc", columnList = "updated_at DESC,deleted_at"),
        @Index(name = "idx_project_deleted_at",columnList = "deleted_at")
        })

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    ProjectRole projectRole;

    String name;

    Boolean isPublic = false;

    @CreationTimestamp
    Instant createdAt;

    Instant deletedAt;//soft delete

    @UpdateTimestamp
    Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;
}
