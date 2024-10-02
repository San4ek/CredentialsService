package me.inqu1sitor.credentialsservice.handlers.impl;

import lombok.extern.slf4j.Slf4j;
import me.inqu1sitor.credentialsservice.dto.ErrorResponseDto;
import me.inqu1sitor.credentialsservice.exceptions.CodeAuthorisationException;
import me.inqu1sitor.credentialsservice.exceptions.InternalServerError;
import me.inqu1sitor.credentialsservice.exceptions.NotImplementedException;
import me.inqu1sitor.credentialsservice.handlers.CustomExceptionHandler;
import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Profile(ProjectProfiles.REST)
public class CustomExceptionHandlerImpl implements CustomExceptionHandler {

    @Override
    public ErrorResponseDto onInternalServerError(InternalServerError e) {
        logError(e);
        return ErrorResponseDto.
                ofHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR).
                withReason("Internal server error");
    }

    @Override
    public ErrorResponseDto onCodeAuthorisationException(CodeAuthorisationException exception) {
        logWarn(exception.getMessage());
        return ErrorResponseDto.
                ofHttpStatus(HttpStatus.BAD_REQUEST).
                withReason(exception.getMessage());
    }

    @Override
    public ErrorResponseDto onAny(Exception e) {
        logError(e);
        return ErrorResponseDto.
                ofHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR).
                withReason("Internal server error");
    }

    @Override
    public ErrorResponseDto onMethodArgumentNotValid(MethodArgumentNotValidException e) {
        final ErrorResponseDto dto = ErrorResponseDto.ofHttpStatus(HttpStatus.BAD_REQUEST);
        e.getBindingResult().getFieldErrors().
                forEach(fieldError -> dto.reasons().
                        add(String.format("%s : %s",
                                fieldError.getField(),
                                fieldError.getDefaultMessage())));
        logWarn(String.valueOf(dto.reasons()));
        return dto;
    }

    @Override
    public ErrorResponseDto onUnsupportedOperation(NotImplementedException e) {
        logError(e);
        return ErrorResponseDto.
                ofHttpStatus(HttpStatus.NOT_IMPLEMENTED).
                withReason(e.getMessage());
    }

    @Override
    public ErrorResponseDto onMissingServletRequestParameter(MissingServletRequestParameterException e) {
        logWarn(e.getMessage());
        return ErrorResponseDto.ofHttpStatus(HttpStatus.BAD_REQUEST).
                withReason(String.format("Request parameter '%s' is missing", e.getParameterName()));
    }

    @Override
    public ErrorResponseDto onHttpMessageNotReadable(HttpMessageNotReadableException e) {
        logWarn(e.getMessage());
        return ErrorResponseDto.
                ofHttpStatus(HttpStatus.BAD_REQUEST).
                withReason("Unable to read request body");
    }

    private void logWarn(final String message) {
        log.warn("Forbidden: {}", message);
    }

    private void logError(Exception e) {
        log.error(e.getMessage(), e);
    }
}
