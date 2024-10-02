package me.inqu1sitor.credentialsservice.handlers;

import me.inqu1sitor.credentialsservice.dto.ErrorResponseDto;
import me.inqu1sitor.credentialsservice.exceptions.CodeAuthorisationException;
import me.inqu1sitor.credentialsservice.exceptions.InternalServerError;
import me.inqu1sitor.credentialsservice.exceptions.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CustomExceptionHandler {

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponseDto onInternalServerError(final InternalServerError e);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CodeAuthorisationException.class)
    ErrorResponseDto onCodeAuthorisationException(final CodeAuthorisationException e);

    /**
     * Handles any {@link Exception} and sends
     * {@link ErrorResponseDto response} with
     * {@link HttpStatus#INTERNAL_SERVER_ERROR "Internal Server Error"}
     * HTTP status.
     *
     * @param e the thrown {@link Exception exception}
     * @return the {@link ErrorResponseDto errors dto}
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponseDto onAny(final Exception e);

    /**
     * Handles {@link MethodArgumentNotValidException} and sends
     * {@link ErrorResponseDto response} with {@link HttpStatus#BAD_REQUEST "Bad Request"}
     * HTTP status.
     *
     * @param e the thrown {@link MethodArgumentNotValidException exception}
     * @return the {@link ErrorResponseDto errors dto}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponseDto onMethodArgumentNotValid(final MethodArgumentNotValidException e);

    /**
     * Handles {@link NotImplementedException} and sends
     * {@link ErrorResponseDto response} with {@link HttpStatus#NOT_IMPLEMENTED "Not Implemented"}
     * HTTP status.
     *
     * @param e the thrown {@link NotImplementedException exception}
     * @return the {@link ErrorResponseDto errors dto}
     */
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(NotImplementedException.class)
    ErrorResponseDto onUnsupportedOperation(NotImplementedException e);

    /**
     * Handles {@link MissingServletRequestParameterException} and sends
     * {@link ErrorResponseDto response} with {@link HttpStatus#BAD_REQUEST "Bad Request"}
     * HTTP status.
     *
     * @param e the thrown {@link MissingServletRequestParameterException exception}
     * @return the {@link ErrorResponseDto errors dto}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    ErrorResponseDto onMissingServletRequestParameter(MissingServletRequestParameterException e);

    /**
     * Handles {@link HttpMessageNotReadableException} and sends
     * {@link ErrorResponseDto response} with {@link HttpStatus#BAD_REQUEST "Bad Request"}
     * HTTP status.
     *
     * @param e the thrown {@link HttpMessageNotReadableException exception}
     * @return the {@link ErrorResponseDto errors dto}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ErrorResponseDto onHttpMessageNotReadable(HttpMessageNotReadableException e);
}
