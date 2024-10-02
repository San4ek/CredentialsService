package me.inqu1sitor.credentialsservice.dto;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * An error response template with fields clarifying this error.
 *
 * @param code    an error code ({@link HttpStatus#value() HTTP status value})
 * @param name    an error name ({@link HttpStatus#name() HTTP status name})
 * @param reasons a list of reasons caused this error
 * @author Alexander Sankevich
 */
public record ErrorResponseDto(
        int code,
        String name,
        List<String> reasons
) {

    /**
     * Creates a new {@link ErrorResponseDto dto} with an
     * {@link ErrorResponseDto#code error code} and a
     * {@link ErrorResponseDto#name name} specified by
     * the provided parameter {@code httpStatus}.
     *
     * @param httpStatus the {@link HttpStatus} of the error
     * @return the new {@link ErrorResponseDto dto}
     */
    public static ErrorResponseDto ofHttpStatus(final HttpStatus httpStatus) {
        return new ErrorResponseDto(httpStatus.value(), httpStatus.getReasonPhrase(), new ArrayList<>());
    }

    /**
     * Adds an error reason to the
     * {@link ErrorResponseDto#reasons list of the error reasons}.
     *
     * @param reason the reason caused the error
     * @return the {@link ErrorResponseDto dto} with updated
     * {@link ErrorResponseDto#reasons list of the error reasons}
     */
    public ErrorResponseDto withReason(final String reason) {
        this.reasons.add(reason);
        return this;
    }
}
