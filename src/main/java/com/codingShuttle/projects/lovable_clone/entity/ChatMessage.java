package com.codingShuttle.projects.lovable_clone.entity;

import com.codingShuttle.projects.lovable_clone.enums.MessageRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;

public class ChatMessage {


    Long id;

    MessageRole role;

    ChatSession chatSession;

    String content;

    String toolCalls;
    Integer tokenUsed;
    Instant createdAt;
}
