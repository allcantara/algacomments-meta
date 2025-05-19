package com.algaworks.comment.infrastructure.persistence;

import com.algaworks.comment.core.exception.CommentNotFoundException;
import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import com.algaworks.comment.domain.repository.CommentRepository;
import com.algaworks.comment.infrastructure.persistence.converter.CommentConverter;
import com.algaworks.comment.infrastructure.persistence.entities.CommentEntity;
import com.algaworks.comment.infrastructure.persistence.jpa.CommentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static com.algaworks.comment.infrastructure.persistence.converter.CommentConverter.toEntity;
import static com.algaworks.comment.infrastructure.persistence.converter.CommentConverter.toOutput;

@Component
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    @Autowired
    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
    }

    @Override
    public CommentOutput save(CommentInput commentInput) {
        CommentEntity commentEntity = commentJpaRepository.saveAndFlush(toEntity(commentInput));
        return toOutput(commentEntity);
    }

    @Override
    public CommentOutput findById(UUID id) {
        Optional<CommentEntity> optionalCommentEntity = commentJpaRepository.findById(id);
        return optionalCommentEntity.map(CommentConverter::toOutput).orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public Page<CommentOutput> findAll(Pageable pageable) {
        Page<CommentEntity> pageCommentEntity = commentJpaRepository.findAll(pageable);
        return pageCommentEntity.map(CommentConverter::toOutput);
    }

}
