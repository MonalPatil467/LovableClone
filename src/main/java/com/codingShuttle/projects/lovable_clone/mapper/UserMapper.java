package com.codingShuttle.projects.lovable_clone.mapper;

import com.codingShuttle.projects.lovable_clone.dto.SignUpRequest;
import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import com.codingShuttle.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignUpRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
