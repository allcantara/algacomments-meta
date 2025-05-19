package com.algaworks.moderation.domain.models;

import java.util.UUID;

public record ModerationInput(
        String text,
        UUID commentId
) {
}
