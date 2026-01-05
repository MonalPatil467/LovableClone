package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutRequest;
import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.PortalResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.codingShuttle.projects.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceimpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getMySubscription(Long userId) {
        return null;
    }

    @Override
    public CheckOutResponse createCheckoutSessionUrl(CheckOutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
