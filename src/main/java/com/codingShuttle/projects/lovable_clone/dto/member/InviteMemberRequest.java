package com.codingShuttle.projects.lovable_clone.dto.member;

import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
