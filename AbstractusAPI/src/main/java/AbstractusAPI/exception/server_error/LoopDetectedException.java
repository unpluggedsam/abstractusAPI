package AbstractusAPI.exception.server_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href ="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/508>The server detected an infinite loop while processing the request.</a>
 */
public class LoopDetectedException extends AbstractusException {
    public LoopDetectedException(String message) {
        super(message, 508);
    }
}
