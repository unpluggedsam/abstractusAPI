package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses>The resource that is being accessed is locked.</a>
 */
public class LockedException extends AbstractusException  {
    public LockedException(String message) {
        super(message, 423);
    }
}
