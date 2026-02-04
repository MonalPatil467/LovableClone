package com.codingShuttle.projects.lovable_clone.service.impl;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutRequest;
import com.codingShuttle.projects.lovable_clone.dto.subscription.CheckOutResponse;
import com.codingShuttle.projects.lovable_clone.dto.subscription.PortalResponse;
import com.codingShuttle.projects.lovable_clone.entity.Plan;
import com.codingShuttle.projects.lovable_clone.error.ResourceNotFoundException;
import com.codingShuttle.projects.lovable_clone.repository.PlanRepository;
import com.codingShuttle.projects.lovable_clone.security.AuthUtil;
import com.codingShuttle.projects.lovable_clone.service.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public class StripePaymentProcessor implements PaymentProcessor {

    private final AuthUtil authUtil;
    private final PlanRepository planRepository;

    @Value("${client.url}")
    private String frontendUrl;
    @Override
    public CheckOutResponse createCheckoutSessionUrl(CheckOutRequest request) throws StripeException {

        Plan plan = planRepository.findById(request.planId())
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        Long userId = authUtil.getCurrentUserId();

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setPrice(plan.getStripePriceId())
                                .setQuantity(1L)
                                .build()
                )
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setSuccessUrl(frontendUrl + "/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(frontendUrl + "/cancel.html")
                .putMetadata("user_id", userId.toString())
                .putMetadata("plan_id", plan.getId().toString())
                .build();

        Session session = Session.create(params);

        return new CheckOutResponse(session.getId(), session.getUrl());
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}