package me.inqu1sitor.credentialsservice.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotImplementedException extends UnsupportedOperationException {

    private static final NotImplementedException notImplementedException = new NotImplementedException("Not implemented yet");

    public NotImplementedException(String message) {
        super(message);
    }

    public static NotImplementedException defaultInstance() {
        return notImplementedException;
    }
}
