package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href ="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/415>The HTTP 415 Unsupported Media Type client error response code
 * indicates that the server refuses to accept the request because the payload format is in an unsupported format.</a>
 */
public class UnsupportedMediaTypeException extends AbstractusException {
    public UnsupportedMediaTypeException(String message) {
        super(message, 415);
    }
}
