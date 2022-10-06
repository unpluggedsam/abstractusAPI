package abstractusAPI.exception.server_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/501>The request method is not supported by the server and cannot be handled.
 * The only methods that servers are required to support (and therefore that must not return this code) are GET and HEAD.</a>"
 */
public class NotImplementedException extends AbstractusException {
    public NotImplementedException(String message) {
        super(message, 501);
    }
}
