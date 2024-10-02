package me.inqu1sitor.credentialsservice.auth.cookie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CodeCookieGeneratorImpl implements CodeCookieGenerator {

    @Value("${authcode.path}")
    private String codeAuthPath;

    @Value("${authcode.ttl}")
    private long ttl;

    @Value("${authcode.cookie.name}")
    private String cookieName;

    @Value("${authcode.cookie.http-only}")
    private boolean httpOnly;

    @Override
    public HttpCookie generate(String name, String value, long ttl, boolean httpOnly, String path) {
        return ResponseCookie.from(name, value).path(path).maxAge(ttl).httpOnly(httpOnly).build();
    }

    @Override
    public HttpCookie generate(String value) {
        return generate(cookieName, value, ttl, httpOnly, codeAuthPath);
    }
}
