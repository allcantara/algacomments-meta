package com.algaworks.comment.domain.service;

import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import com.algaworks.comment.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentOutput create(CommentInput commentInput) {
        return commentRepository.save(commentInput);
    }

    public CommentOutput findById(UUID id) {
        return commentRepository.findById(id);
    }

    public Page<CommentOutput> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

}
