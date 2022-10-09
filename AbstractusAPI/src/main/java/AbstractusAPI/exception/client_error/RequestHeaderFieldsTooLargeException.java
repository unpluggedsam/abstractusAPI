package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/431"> The HTTP 431 Request Header Fields Too Large response status code indicates that the server
 * refuses to process the request because the request's HTTP headers are too long. The request may be resubmitted after reducing the size of the request headers. </a>
 */
public class RequestHeaderFieldsTooLargeException extends AbstractusException {
    public RequestHeaderFieldsTooLargeException(String message) {
        super(message, 431);
    }
}
