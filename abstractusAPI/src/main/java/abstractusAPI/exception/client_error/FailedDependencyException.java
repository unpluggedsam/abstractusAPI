package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses">The resource that is being accessed is locked.</a>
 */
public class FailedDependencyException extends AbstractusException {

    public FailedDependencyException(String message) {
        super(message, 424);
    }
}
