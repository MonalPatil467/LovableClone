package com.codingShuttle.projects.lovable_clone.controller;

import com.codingShuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingShuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingShuttle.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.codingShuttle.projects.lovable_clone.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;//constructor dependency injection

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
            @PathVariable Long projectId,
            @RequestBody @Valid InviteMemberRequest request
    ){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId,request));
    }
    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody @Valid UpdateMemberRoleRequest request){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(
                projectId,memberId,request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId)
    {
        Long userId=1L;
        projectMemberService.deleteMemberRole(projectId,memberId,userId);
        return ResponseEntity.noContent().build();
    }
}
