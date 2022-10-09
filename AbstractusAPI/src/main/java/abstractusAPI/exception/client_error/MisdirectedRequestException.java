package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses">The request was directed at a server that is not able to produce a response.
 * This can be sent by a server that is not configured to produce responses for the combination of scheme and authority that are included in the request URI.</a>
 */
public class MisdirectedRequestException extends AbstractusException {
    public MisdirectedRequestException(String message) {
        super(message, 421);
    }
}
