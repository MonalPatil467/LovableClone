package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.project.ProjectRequest;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectResponse;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    @Nullable List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectsById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id,ProjectRequest request);

    void softDelete(Long id);
}
