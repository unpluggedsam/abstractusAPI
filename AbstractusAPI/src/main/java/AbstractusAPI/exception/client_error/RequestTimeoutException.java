package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408">The HyperText Transfer Protocol (HTTP) 408 Request
 * Timeout response status code means that the server would like to shut down this unused connection.
 * It is sent on an idle connection by some servers, even without any previous request by the client.</a>
 */
public class RequestTimeoutException extends AbstractusException {
    public RequestTimeoutException(String message) {
        super(message, 408);
    }
}
