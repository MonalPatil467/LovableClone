package com.codingShuttle.projects.lovable_clone.dto.subscription;

public record UsageTodayResponse(
        Integer TokensUsed,
        Integer TokensLimit,
        Integer PreviewsRunning,
        Integer PreviewsLimit
) {
}
