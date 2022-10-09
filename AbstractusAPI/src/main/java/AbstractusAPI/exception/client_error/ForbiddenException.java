package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/403"> The client does not have access rights to the content; that is, it is unauthorized,
 * so the server is refusing to give the requested resource. Unlike 401 Unauthorized, the client's identity is known to the server. </a>
 */
public class ForbiddenException extends AbstractusException  {
    public ForbiddenException(String message) {
        super(message, 403);
    }
}
