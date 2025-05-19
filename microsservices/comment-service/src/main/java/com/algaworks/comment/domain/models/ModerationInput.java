package com.algaworks.comment.domain.models;

import java.util.UUID;

public record ModerationInput(
        String text,
        UUID commentId
) {
}
