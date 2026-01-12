package com.codingShuttle.projects.lovable_clone.dto.member;

import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
