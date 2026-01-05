package com.codingShuttle.projects.lovable_clone.dto;

public record SignUpRequest(
        String email,
        String name,
        String password
) {
}
