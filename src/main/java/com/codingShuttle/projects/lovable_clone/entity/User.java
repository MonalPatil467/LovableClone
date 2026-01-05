package com.codingShuttle.projects.lovable_clone.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@FieldDefaults(level= AccessLevel.PRIVATE)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String email;
     String passwordHash;

    String avatarUrl;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant deletedAt;

    //soft delete
    Instant updatedAt;
}
