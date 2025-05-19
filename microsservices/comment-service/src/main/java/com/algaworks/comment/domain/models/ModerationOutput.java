package com.algaworks.comment.domain.models;

public record ModerationOutput(
        Boolean approved,
        String reason
) {
}
