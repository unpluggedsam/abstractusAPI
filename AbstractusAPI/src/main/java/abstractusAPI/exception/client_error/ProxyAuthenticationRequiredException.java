package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/407"> This is similar to 401 Unauthorized but authentication is needed to be done by a proxy. </a>
 */
public class ProxyAuthenticationRequiredException extends AbstractusException {
    public ProxyAuthenticationRequiredException(String message) {
        super(message, 407);
    }
}
