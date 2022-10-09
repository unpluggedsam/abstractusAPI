package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429>The user has sent too many requests in a given amount of time ("rate limiting").</a>"
 */
public class RateLimitingException extends AbstractusException {
    public RateLimitingException(String message) {
        super(message, 429);
    }
}
