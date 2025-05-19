package com.algaworks.comment.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class CommentEntity {

    @Id
    private UUID id;

    private String text;

    private String author;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    public CommentEntity(UUID id, String text, String author, OffsetDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.createdAt = createdAt;
    }

    public CommentEntity() {

    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

}
