package com.codingShuttle.projects.lovable_clone.controller;

import com.codingShuttle.projects.lovable_clone.dto.Files.FileContentResponse;
import com.codingShuttle.projects.lovable_clone.dto.Files.FileNode;
import com.codingShuttle.projects.lovable_clone.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FilesController {

    private final FileService fileService;

    @GetMapping
   public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }

    @GetMapping("{*path}")// /src/hooks/get-user.jsx
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId,path,userId));
    }
}
