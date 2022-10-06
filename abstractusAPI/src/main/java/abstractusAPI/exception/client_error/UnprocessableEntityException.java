package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/422">The HyperText Transfer Protocol (HTTP) 422 Unprocessable
 * Entity response status code indicates that the server understands the content type of the request entity,
 * and the syntax of the request entity is correct, but it was unable to process the contained instructions.</a>
 */
public class UnprocessableEntityException extends AbstractusException {
    public UnprocessableEntityException(String message) {
        super(message, 422);
    }
}
