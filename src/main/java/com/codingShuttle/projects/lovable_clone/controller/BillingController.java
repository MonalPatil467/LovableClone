package com.codingShuttle.projects.lovable_clone.controller;

import com.codingShuttle.projects.lovable_clone.dto.subscription.*;
import com.codingShuttle.projects.lovable_clone.service.PaymentProcessor;
import com.codingShuttle.projects.lovable_clone.service.PlanService;
import com.codingShuttle.projects.lovable_clone.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private  final PlanService planService;
    private final SubscriptionService subscriptionService;

    private final PaymentProcessor paymentProcessor;
    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){

        return ResponseEntity.ok(subscriptionService.getMySubscription());
    }

    @SneakyThrows
    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckOutResponse> createCheckoutResponse(
            @RequestBody CheckOutRequest request
    ){

        return ResponseEntity.ok(paymentProcessor.createCheckoutSessionUrl(request));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        Long userId=1L;
        return ResponseEntity.ok(paymentProcessor.openCustomerPortal(userId));
    }

}
