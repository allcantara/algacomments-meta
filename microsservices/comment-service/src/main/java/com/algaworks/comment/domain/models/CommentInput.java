package com.algaworks.comment.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public record CommentInput(
        @JsonIgnore
        UUID id,
        String text,
        String author
) {
}
