package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/409>The HTTP 409 Conflict response status code indicates a request conflict with the current state of the target resource.</a>
 */
public class ConflictException extends AbstractusException  {
    public ConflictException(String message) {
        super(message, 409);
    }
}
