package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingShuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingShuttle.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.codingShuttle.projects.lovable_clone.entity.Project;
import com.codingShuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingShuttle.projects.lovable_clone.entity.ProjectMemberId;
import com.codingShuttle.projects.lovable_clone.entity.User;
import com.codingShuttle.projects.lovable_clone.mapper.ProjectMemberResponseMapper;
import com.codingShuttle.projects.lovable_clone.repository.ProjectMemberRepository;
import com.codingShuttle.projects.lovable_clone.repository.ProjectRepository;
import com.codingShuttle.projects.lovable_clone.repository.UserRepository;
import com.codingShuttle.projects.lovable_clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
@RequiredArgsConstructor
public class ProjectMemberServiceimpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberResponseMapper projectMemberResponseMapper;
    UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberResponseMapper.toProjectMemberResponseFromOwner(project.getOwner()));
        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberResponseMapper::toProjectMemberResponseFromMember)
                        .toList());
        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Access Denied");
        }
        User invitee = userRepository.findByEmail(request.email()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("you are trying to invite yourself");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
        throw new RuntimeException("Member already exists");
        }

        ProjectMember member=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
       projectMemberRepository.save(member);
       return projectMemberResponseMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);
        if(project.getOwner().getId().equals(memberId)){
            throw new RuntimeException("Not Allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember=projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberResponseMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse deleteMemberRole(Long projectId, Long memberId, Long userId) {
        return null;
    }

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.getAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
