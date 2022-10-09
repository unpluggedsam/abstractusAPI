package AbstractusAPI.exception.server_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/502>This error response means that the server, while working as a gateway to get
 * a response needed to handle the request, got an invalid response.</a>"
 */
public class BadGatewayException extends AbstractusException {
    public BadGatewayException(String message) {
        super(message, 502);
    }
}
