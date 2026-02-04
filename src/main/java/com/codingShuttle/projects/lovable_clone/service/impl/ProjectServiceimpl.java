package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.project.ProjectRequest;
import com.codingShuttle.projects.lovable_clone.entity.Project;
import com.codingShuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingShuttle.projects.lovable_clone.entity.ProjectMemberId;
import com.codingShuttle.projects.lovable_clone.entity.User;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectResponse;
import com.codingShuttle.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import com.codingShuttle.projects.lovable_clone.error.ResourceNotFoundException;
import com.codingShuttle.projects.lovable_clone.mapper.ProjectMapper;
import com.codingShuttle.projects.lovable_clone.repository.ProjectMemberRepository;
import com.codingShuttle.projects.lovable_clone.repository.ProjectRepository;
import com.codingShuttle.projects.lovable_clone.repository.UserRepository;
import com.codingShuttle.projects.lovable_clone.security.AuthUtil;
import com.codingShuttle.projects.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.jspecify.annotations.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Builder
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ProjectServiceimpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    AuthUtil authUtil;

    ProjectMemberRepository projectMemberRepository;
    @Override
    public @Nullable List<ProjectSummaryResponse> getUserProjects() {

        //Project project;
       // return projectRepository.findAllAccesibleByUser(userId)
         //       .stream()
           //     .map(projectMapper.toProjectSummaryResponse(project))
             //   .collect(Collectors.toList());
        Long userId=authUtil.getCurrentUserId();
        var projects=projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }


    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")// spell:-spring expression language;
    // uses different compiler than java
    public ProjectResponse getUserProjectsById(Long id) {
        Long userId=authUtil.getCurrentUserId();
        Project project=findAccessibleProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId=authUtil.getCurrentUserId();
       User owner=userRepository.findById(userId).orElseThrow();

       Project project= Project.builder()
               .name(request.name())
               .isPublic(false)
               .build();
       project=projectRepository.save(project);
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId=authUtil.getCurrentUserId();
       Project project=findAccessibleProjectById(id,userId);
       project.setName(request.name());
      project= projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#")
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = findAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
    public Project findAccessibleProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).
                orElseThrow(()->new ResourceNotFoundException("Project", projectId.toString()));
    }
}
