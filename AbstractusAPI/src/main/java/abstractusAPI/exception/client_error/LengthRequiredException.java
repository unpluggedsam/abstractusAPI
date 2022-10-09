package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href= "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/411">The HyperText Transfer Protocol (HTTP) 411 Length Required client error
 * response code indicates that the server refuses to accept the request without a defined Content-Length header.</a>
 */
public class LengthRequiredException extends AbstractusException {
    public LengthRequiredException(String message) {
        super(message, 411);
    }
}
