package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408">The server cannot or will not process the request due to something that is perceived
 * to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).</a>
 */
public class BadRequestException extends AbstractusException {
    public BadRequestException(String message) {
        super(message, 400);
    }
}
