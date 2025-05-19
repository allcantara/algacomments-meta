package com.algaworks.comment.domain.gateway;

import com.algaworks.comment.domain.models.ModerationInput;
import com.algaworks.comment.domain.models.ModerationOutput;

public interface ModerationGateway {
    ModerationOutput sendForModeration(ModerationInput moderationInput);
}
