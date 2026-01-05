package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.Files.FileContentResponse;
import com.codingShuttle.projects.lovable_clone.dto.Files.FileNode;
import com.codingShuttle.projects.lovable_clone.dto.subscription.PlanResponse;
import com.codingShuttle.projects.lovable_clone.service.PlanService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceimpl implements PlanService {

    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
