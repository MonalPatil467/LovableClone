package com.codingShuttle.projects.lovable_clone.dto.member;

import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
       @NotNull ProjectRole role,
       String username
) {
}
