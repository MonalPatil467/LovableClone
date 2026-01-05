package com.codingShuttle.projects.lovable_clone.dto;

public record AuthResponse(String token, UserProfileResponse user) {
//record is mutable; can implement a record by using class+private+final+getter+setter but it increase the amount of code

}
