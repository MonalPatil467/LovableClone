package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.UsageTodayResponse;
import com.codingShuttle.projects.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceimpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageofUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsofUser(Long userId) {
        return null;
    }
}
