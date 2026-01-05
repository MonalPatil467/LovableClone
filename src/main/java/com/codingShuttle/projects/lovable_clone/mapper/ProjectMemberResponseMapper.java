package com.codingShuttle.projects.lovable_clone.mapper;

import com.codingShuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingShuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingShuttle.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberResponseMapper {

    // OWNER → MemberResponse
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", ignore = true)          // User has no 'name'
    @Mapping(target = "avatarUrl", source = "avatarUrl")
    @Mapping(target = "role", constant = "OWNER")
    @Mapping(target = "invitedAt", ignore = true)
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    // PROJECT MEMBER → MemberResponse
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", ignore = true)          // User has no 'name'
    @Mapping(target = "avatarUrl", source = "user.avatarUrl")
    @Mapping(target = "role", source = "projectRole")
    @Mapping(target = "invitedAt", source = "invitedAt")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}




