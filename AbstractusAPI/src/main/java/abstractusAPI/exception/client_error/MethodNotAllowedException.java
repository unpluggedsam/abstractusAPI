package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/405"> The request method is known by the server but is not supported by the target resource.
 * For example, an API may not allow calling DELETE to remove a resource. </a>
 */
public class MethodNotAllowedException extends AbstractusException {
    public MethodNotAllowedException(String message) {
        super(message, 405);
    }
}
