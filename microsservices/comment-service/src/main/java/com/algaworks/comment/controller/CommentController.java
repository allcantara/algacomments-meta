package com.algaworks.comment.controller;

import com.algaworks.comment.application.CommentApplication;
import com.algaworks.comment.domain.models.CommentInput;
import com.algaworks.comment.domain.models.CommentOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentApplication commentApplication;

    @Autowired
    public CommentController(CommentApplication commentApplication) {
        this.commentApplication = commentApplication;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentOutput create(@RequestBody CommentInput commentInput) {
        return commentApplication.create(commentInput);
    }

    @GetMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentOutput findById(@PathVariable UUID commentId) {
        return commentApplication.findById(commentId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CommentOutput> findAll(Pageable pageable) {
        return commentApplication.findAll(pageable);
    }


}
