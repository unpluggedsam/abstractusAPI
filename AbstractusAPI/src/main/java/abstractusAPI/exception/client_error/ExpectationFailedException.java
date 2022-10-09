package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/417">The HTTP 417 Expectation Failed client error response code indicates
 * that the expectation given in the request's Expect header could not be met.</a>
 */
public class ExpectationFailedException extends AbstractusException {
    public ExpectationFailedException(String message) {
        super(message, 417);
    }
}
