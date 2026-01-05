package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.Files.FileContentResponse;
import com.codingShuttle.projects.lovable_clone.dto.Files.FileNode;
import com.codingShuttle.projects.lovable_clone.service.FileService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceimpl implements FileService {

    @Override
    public @Nullable List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public @Nullable FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
