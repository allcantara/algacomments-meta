package com.algaworks.comment.application.converter;

import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.ModerationInput;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentConverter {

    public static ModerationInput toModerationInput(CommentInput commentInput) {
        return new ModerationInput(
                commentInput.text(),
                commentInput.id()
        );
    }

}
