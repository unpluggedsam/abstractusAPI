package abstractusAPI.exception.server_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500>The server has encountered a situation it does not know how to handle.</a>"
 */
public class InternalServerErrorException extends AbstractusException {
    public InternalServerErrorException(String message) {
        super(message, 500);
    }
}
