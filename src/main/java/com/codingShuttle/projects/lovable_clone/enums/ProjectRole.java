package com.codingShuttle.projects.lovable_clone.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.codingShuttle.projects.lovable_clone.enums.ProjectPermissions.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(VIEW,EDIT,DELETE,VIEW_MEMBERS),
    VIEWER(Set.of(VIEW,VIEW_MEMBERS)),
    OWNER(Set.of(VIEW,EDIT,DELETE,MANAGE_MEMBERS,VIEW_MEMBERS));

    ProjectRole(ProjectPermissions... permissions){
        this.permissions=Set.of(permissions);
    }
    private final Set<ProjectPermissions> permissions;//to map roles and permission
}
