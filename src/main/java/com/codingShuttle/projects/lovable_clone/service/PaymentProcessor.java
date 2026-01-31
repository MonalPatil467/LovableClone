package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutRequest;
import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.PortalResponse;

public interface PaymentProcessor  {
    public CheckOutResponse createCheckoutSessionUrl(CheckOutRequest request) throws Throwable;

    public PortalResponse openCustomerPortal(Long userId);
}
