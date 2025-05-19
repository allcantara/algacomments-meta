package com.algaworks.moderation.infrastructure.validation;

import com.algaworks.moderation.domain.gateway.WordValidationGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordValidationGatewayImpl implements WordValidationGateway {

    private final List<String> forbiddenWords;

    public WordValidationGatewayImpl() {
        this.forbiddenWords = List.of("ódio", "xingamento");
    }

    @Override
    public Boolean validate(String word) {
        return !forbiddenWords.contains(word.toLowerCase());
    }

}
