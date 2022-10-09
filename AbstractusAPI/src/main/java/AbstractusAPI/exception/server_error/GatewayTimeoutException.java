package AbstractusAPI.exception.server_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/504>This error response is given when the server is acting as a gateway and cannot get a response in time.</a>"
 */
public class GatewayTimeoutException extends AbstractusException {
    public GatewayTimeoutException(String message) {
        super(message, 504);
    }
}
