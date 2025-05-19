package com.algaworks.comment.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.channels.ClosedChannelException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            SocketTimeoutException.class,
            ConnectException.class,
            ClosedChannelException.class
    })
    public ProblemDetail handle(IOException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.GATEWAY_TIMEOUT);

        problemDetail.setTitle("Gateway Timeout");
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(URI.create("errors/gateway-timeout"));

        return problemDetail;
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ProblemDetail handle(CommentNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(URI.create("errors/not-found"));

        return problemDetail;
    }

    @ExceptionHandler(CommentNotApprovedException.class)
    public ProblemDetail handle(CommentNotApprovedException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Not Approved");
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(URI.create("errors/not-approved"));

        return problemDetail;
    }

    @ExceptionHandler(ModerationClientBadGatewayException.class)
    public ProblemDetail handle(ModerationClientBadGatewayException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_GATEWAY);

        problemDetail.setTitle("Bad Gateway");
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(URI.create("errors/bad-gateway"));

        return problemDetail;
    }

}
