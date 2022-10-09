package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/451">The user agent requested a resource that cannot legally be provided, such as a web page censored by a government.</a>
 */
public class UnavailableForLegalReasonsException extends AbstractusException {
    public UnavailableForLegalReasonsException(String message) {
        super(message, 451);
    }
}
