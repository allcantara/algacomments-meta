package com.algaworks.moderation.application;

import com.algaworks.moderation.domain.models.ModerationInput;
import com.algaworks.moderation.domain.models.ModerationOutput;
import com.algaworks.moderation.domain.services.ModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModerationApplication {

    private final ModerationService moderationService;

    @Autowired
    public ModerationApplication(ModerationService moderationService) {
        this.moderationService = moderationService;
    }

    public ModerationOutput verifyIfWordIsValid(ModerationInput moderationInput) {
        return moderationService.verify(moderationInput);
    }

}
