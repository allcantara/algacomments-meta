package com.algaworks.moderation.domain.services;

import com.algaworks.moderation.domain.gateway.WordValidationGateway;
import com.algaworks.moderation.domain.models.ModerationInput;
import com.algaworks.moderation.domain.models.ModerationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;

@Service
public class ModerationService {

    public static final String WORD_SENT_IS_VALID = "The word sent is valid";
    public static final String WORD_SENT_IS_PROHIBITED = "The word sent is prohibited";

    private final WordValidationGateway wordValidationGateway;

    @Autowired
    public ModerationService(WordValidationGateway wordValidationGateway) {
        this.wordValidationGateway = wordValidationGateway;
    }

    public ModerationOutput verify(ModerationInput moderationInput) {
        Boolean isApproved = wordValidationGateway.validate(moderationInput.text());
        return new ModerationOutput(isApproved, buildReason(isApproved));
    }

    protected String buildReason(Boolean isApproved) {
        return TRUE.equals(isApproved) ? WORD_SENT_IS_VALID : WORD_SENT_IS_PROHIBITED;
    }

}
