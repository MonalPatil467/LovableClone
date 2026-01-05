package com.codingShuttle.projects.lovable_clone.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(
        String ProjectName,
        Long id,
        Instant createdAt,
        Instant updatedAt
) {
}
