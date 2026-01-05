package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
   public List<PlanResponse> getAllActivePlans();
}
