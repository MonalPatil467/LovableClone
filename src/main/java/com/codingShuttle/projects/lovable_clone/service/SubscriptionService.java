package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutRequest;
import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.PortalResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getMySubscription(Long userId);

  public CheckOutResponse createCheckoutSessionUrl(CheckOutRequest request, Long userId);

   public PortalResponse openCustomerPortal(Long userId);
}
