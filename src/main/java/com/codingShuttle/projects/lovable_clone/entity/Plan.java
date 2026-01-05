package com.codingShuttle.projects.lovable_clone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level= AccessLevel.PRIVATE)
public class Plan {

    Long id;
    String name;

    //SubscriptionEnum status;
    String stripePriceId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews;
    Boolean unlimitedAi; //unlimited access to LLM

    Boolean active;

}
