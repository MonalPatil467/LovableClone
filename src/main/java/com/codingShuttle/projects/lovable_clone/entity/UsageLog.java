package com.codingShuttle.projects.lovable_clone.entity;

import java.time.Instant;

public class UsageLog {
    Long id;
    User user;
    Project project;

    String actions;

    Integer tokenUsed;
    Integer durationMs;

    String metaData;

    Instant createdAt;
}
