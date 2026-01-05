package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.Files.FileContentResponse;
import com.codingShuttle.projects.lovable_clone.dto.Files.FileNode;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FileService {
    @Nullable List<FileNode> getFileTree(Long projectId, Long userId);

    @Nullable FileContentResponse getFileContent(Long projectId, String path, Long userId);

}
