package com.codingShuttle.projects.lovable_clone.security;

import com.codingShuttle.projects.lovable_clone.enums.ProjectPermissions;
import com.codingShuttle.projects.lovable_clone.enums.ProjectRole;
import com.codingShuttle.projects.lovable_clone.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {
   private final ProjectMemberRepository projectMemberRepository;

   private final AuthUtil authUtil;

   private boolean hasPermission(Long projectId,ProjectPermissions projectPermissions){
       Long userId= authUtil.getCurrentUserId();

       return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId)
               .map(role -> role.getPermissions().contains(projectPermissions))
               .orElse(false);
   }
    public boolean canViewProject(Long projectId){
        return hasPermission(projectId,ProjectPermissions.VIEW);

    }

    public boolean canManageProject(Long projectId){
        return hasPermission(projectId,ProjectPermissions.MANAGE_MEMBERS);
    }

    public boolean canViewMembers(Long projectId){
        return hasPermission(projectId,ProjectPermissions.VIEW_MEMBERS);
    }

    public boolean canDeleteProject(Long projectId){
       return hasPermission(projectId,ProjectPermissions.DELETE);
    }
    public boolean canEditProject(Long projectId){
        return hasPermission(projectId,ProjectPermissions.EDIT);
    }
}
