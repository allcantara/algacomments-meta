package com.algaworks.comment.domain.service;

import com.algaworks.comment.core.exception.CommentNotApprovedException;
import com.algaworks.comment.domain.gateway.ModerationGateway;
import com.algaworks.comment.domain.models.ModerationInput;
import com.algaworks.comment.domain.models.ModerationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;

@Service
public class ModerationService {

    private final ModerationGateway moderationGateway;

    @Autowired
    public ModerationService(ModerationGateway moderationGateway) {
        this.moderationGateway = moderationGateway;
    }

    public void verifyIfWordIsValid(ModerationInput moderationInput) {
        ModerationOutput moderationOutput = moderationGateway.sendForModeration(moderationInput);

        if (FALSE.equals(moderationOutput.approved())) {
            throw new CommentNotApprovedException(moderationOutput.reason());
        }
    }

}
