package me.inqu1sitor.credentialsservice.auth.cookie;

import org.springframework.http.HttpCookie;

public interface CodeCookieGenerator {

    HttpCookie generate(final String name, final String value, final long ttl, final boolean httpOnly, final String path);

    HttpCookie generate(final String value);
}
