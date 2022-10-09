package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/413">The HTTP 413 Payload Too Large response status code indicates that the request entity is larger than
 * limits defined by server; the server might close the connection or return a Retry-After header field.</a>
 */
public class PayloadTooLargeException extends AbstractusException {
    public PayloadTooLargeException(String message) {
        super(message, 413);
    }
}
