package AbstractusAPI.exception.server_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/510">The server detected an infinite loop while processing the request.</a>
 */
public class NotExtendedException extends AbstractusException {
    public NotExtendedException(String message) {
        super(message, 510);
    }
}
