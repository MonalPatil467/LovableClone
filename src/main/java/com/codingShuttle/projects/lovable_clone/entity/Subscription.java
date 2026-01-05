package com.codingShuttle.projects.lovable_clone.entity;

import com.codingShuttle.projects.lovable_clone.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Subscription {
    Long id;
    User user;
    Plan plan;

    String StripeCustomerId;
    String StripeSubscription;

    SubscriptionStatus status;

    Integer CurrentPeriodStart;
    Integer CurrentPeriodEnd;
    Boolean cancelAtPeriodEnd;

    Instant updatedAt;
    Instant createdAt;
}
