package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/410">This response is sent when the requested content has been permanently deleted from server, with no forwarding address.
 *  Clients are expected to remove their caches and links to the resource. The HTTP specification intends this status code to be used for
 * "limited-time, promotional services". APIs should not feel compelled to indicate resources that have been deleted with this status code.</a>
 */
public class GoneException extends AbstractusException {
    public GoneException(String message) {
        super(message, 410);
    }
}
