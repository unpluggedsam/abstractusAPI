package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/414">The HTTP 414 URI Too Long response status code indicates that
 * the URI requested by the client is longer than the server is willing to interpret.</a>
 */
public class URITooLongException extends AbstractusException  {
    public URITooLongException(String message) {
        super(message, 414);
    }
}
