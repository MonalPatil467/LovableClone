package com.codingShuttle.projects.lovable_clone.dto.Files;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}
