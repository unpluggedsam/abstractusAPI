package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 *  * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/401">Although the HTTP standard specifies "unauthorized", semantically this response means
 *  "unauthenticated". That is, the client must authenticate itself to get the requested response.</a>
 */
public class UnauthorizedException extends AbstractusException {
    public UnauthorizedException(String message) {
        super(message, 401);
    }
}
