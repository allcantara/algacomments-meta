package com.algaworks.comment.infrastructure.persistence.converter;

import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import com.algaworks.comment.infrastructure.persistence.entities.CommentEntity;
import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;

@UtilityClass
public class CommentConverter {

    public static CommentEntity toEntity(CommentInput commentInput) {
        return new CommentEntity(
                commentInput.id(),
                commentInput.text(),
                commentInput.author(),
                OffsetDateTime.now()
        );
    }

    public static CommentOutput toOutput(CommentEntity commentEntity) {
        return new CommentOutput(
                commentEntity.getId(),
                commentEntity.getText(),
                commentEntity.getAuthor(),
                commentEntity.getCreatedAt()
        );
    }

}
