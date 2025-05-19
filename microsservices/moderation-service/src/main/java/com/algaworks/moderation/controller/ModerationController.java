package com.algaworks.moderation.controller;

import com.algaworks.moderation.application.ModerationApplication;
import com.algaworks.moderation.domain.models.ModerationInput;
import com.algaworks.moderation.domain.models.ModerationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderate")
public class ModerationController {

    private final ModerationApplication moderationApplication;

    @Autowired
    public ModerationController(ModerationApplication moderationApplication) {
        this.moderationApplication = moderationApplication;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput moderateText(@RequestBody ModerationInput moderationInput) {
        return moderationApplication.verifyIfWordIsValid(moderationInput);
    }

}
