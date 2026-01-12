package com.codingShuttle.projects.lovable_clone.entity;

import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.Instant;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="project_member")
public class ProjectMember {

   @EmbeddedId
    ProjectMemberId id;

    @ManyToOne
    @MapsId("projectId")
    Project project;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    @ManyToOne
            @MapsId("userId")
            User user;

    Instant createdAt;

    Instant invitedAt;

    Instant acceptedAt;

}
