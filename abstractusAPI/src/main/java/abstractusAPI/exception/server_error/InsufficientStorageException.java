package abstractusAPI.exception.server_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/507>The method could not be performed on the resource because the server is unable to store
 * the representation needed to successfully complete the request.</a>"
 */
public class InsufficientStorageException extends AbstractusException {
    public InsufficientStorageException(String message) {
        super(message, 507);
    }
}
