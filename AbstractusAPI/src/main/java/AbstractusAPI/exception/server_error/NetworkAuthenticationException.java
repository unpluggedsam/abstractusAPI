package AbstractusAPI.exception.server_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/511>Indicates that the client needs to authenticate to gain network access.</a>"
 */
public class NetworkAuthenticationException extends AbstractusException {
    public NetworkAuthenticationException(String message) {
        super(message, 511);
    }
}
