package com.algaworks.comment.infrastructure.client;

import com.algaworks.comment.core.exception.ModerationClientBadGatewayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Component
public class RestClientFactory {

    private final RestClient.Builder restClientBuilder;

    @Autowired
    public RestClientFactory(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public RestClient moderationRestClient() {
        return restClientBuilder.baseUrl("http://localhost:8081")
                .requestFactory(createFactory())
                .defaultStatusHandler(HttpStatusCode::isError, (request, response) -> {
                    throw new ModerationClientBadGatewayException();
                })
                .build();
    }

    private ClientHttpRequestFactory createFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setReadTimeout(Duration.ofSeconds(10));
        factory.setConnectTimeout(Duration.ofSeconds(10));

        return factory;
    }
}
