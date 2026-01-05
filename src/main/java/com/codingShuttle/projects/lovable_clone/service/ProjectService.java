package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.project.ProjectRequest;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectResponse;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    @Nullable List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectsById(Long id,Long userId);

    ProjectResponse createProject(ProjectRequest request,Long userId);

    ProjectResponse updateProject(Long id,ProjectRequest request,Long userId);

    void softDelete(Long id, Long userId);
}
