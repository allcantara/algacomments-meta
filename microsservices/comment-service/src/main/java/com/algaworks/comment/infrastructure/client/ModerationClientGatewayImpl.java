package com.algaworks.comment.infrastructure.client;

import com.algaworks.comment.domain.gateway.ModerationGateway;
import com.algaworks.comment.domain.models.ModerationInput;
import com.algaworks.comment.domain.models.ModerationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ModerationClientGatewayImpl implements ModerationGateway {

    private final RestClient restClient;

    @Autowired
    public ModerationClientGatewayImpl(RestClientFactory restClientFactory) {
        this.restClient = restClientFactory.moderationRestClient();
    }

    @Override
    public ModerationOutput sendForModeration(ModerationInput moderationInput) {
        return restClient.post()
                .uri("/api/moderate")
                .body(moderationInput)
                .retrieve()
                .body(ModerationOutput.class);
    }

}
