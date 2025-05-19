package com.algaworks.moderation.domain.models;

public record ModerationOutput(
        Boolean approved,
        String reason
) {
}
