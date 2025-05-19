package com.algaworks.comment.domain.repository;

import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CommentRepository {

    CommentOutput save(CommentInput commentInput);

    CommentOutput findById(UUID id);

    Page<CommentOutput> findAll(Pageable pageable);

}
