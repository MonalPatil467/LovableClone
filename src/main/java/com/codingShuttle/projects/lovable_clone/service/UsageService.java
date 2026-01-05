package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
     UsageTodayResponse getTodayUsageofUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsofUser(Long userId);
}
