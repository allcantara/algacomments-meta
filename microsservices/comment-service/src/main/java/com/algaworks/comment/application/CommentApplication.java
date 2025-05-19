package com.algaworks.comment.application;

import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import com.algaworks.comment.domain.service.CommentService;
import com.algaworks.comment.domain.service.ModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.algaworks.comment.application.converter.CommentConverter.toModerationInput;
import static com.algaworks.comment.core.utils.IdGenerator.generateUUID;

@Service
public class CommentApplication {

    private final CommentService commentService;
    private final ModerationService moderationService;

    @Autowired
    public CommentApplication(CommentService commentService, ModerationService moderationService) {
        this.commentService = commentService;
        this.moderationService = moderationService;
    }

    public CommentOutput create(CommentInput commentInput) {
        commentInput = new CommentInput(generateUUID(), commentInput.text(), commentInput.author());

        moderationService.verifyIfWordIsValid(toModerationInput(commentInput));

        return commentService.create(commentInput);
    }

    public CommentOutput findById(UUID commentId) {
        return commentService.findById(commentId);
    }

    public Page<CommentOutput> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

}
