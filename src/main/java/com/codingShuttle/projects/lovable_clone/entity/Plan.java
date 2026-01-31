package com.codingShuttle.projects.lovable_clone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class Plan {

    @Id
    Long id;

    String name;

    //SubscriptionEnum status;
    @Column(unique = true)
    String stripePriceId;

    Integer maxProjects;

    Integer maxTokensPerDay;

    Integer maxPreviews;

    Boolean unlimitedAi; //unlimited access to LLM

    Boolean active;

}
