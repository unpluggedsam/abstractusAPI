package abstractusAPI.exception.server_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/505>The HTTP version used in the request is not supported by the server.</a>"
 */
public class HTTPVersionNotSupportedException extends AbstractusException {
    public HTTPVersionNotSupportedException(String message) {
        super(message, 505);
    }
}
