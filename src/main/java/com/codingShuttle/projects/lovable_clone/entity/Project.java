package com.codingShuttle.projects.lovable_clone.entity;

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
@Table(name="projects")
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    User owner;

    String name;
//String owner;

    Boolean isPublic=false;

    @CreationTimestamp
    Instant createdAt;
    Instant deletedAt;//soft delete

    @UpdateTimestamp
    Instant updatedAt;
}
