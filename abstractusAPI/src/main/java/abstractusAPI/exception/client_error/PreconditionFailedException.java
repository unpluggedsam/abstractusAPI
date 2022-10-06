package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/412">The HyperText Transfer Protocol (HTTP) 412 Precondition Failed client error response
 * code indicates that access to the target resource has been denied. This happens with conditional requests on methods other than GET or HEAD when the condition
 * defined by the If-Unmodified-Since or If-None-Match headers is not fulfilled. In that case, the request, usually an upload or a modification of a resource,
 * cannot be made and this error response is sent back.</a>
 */
public class PreconditionFailedException extends AbstractusException {
    public PreconditionFailedException(String message) {
        super(message, 412);
    }
}
