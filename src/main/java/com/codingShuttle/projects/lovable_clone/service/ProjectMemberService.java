package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingShuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingShuttle.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
     List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    MemberResponse deleteMemberRole(Long projectId, Long memberId, Long userId);

    void removeProjectMember(Long projectId, Long memberId);
}
