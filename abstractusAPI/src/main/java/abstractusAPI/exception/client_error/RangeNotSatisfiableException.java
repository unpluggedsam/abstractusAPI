package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href ="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/416>The HyperText Transfer Protocol (HTTP) 416 Range Not Satisfiable error response code indicates
 * that a server cannot serve the requested ranges. The most likely reason is that the document doesn't contain such ranges, or that the Range header value,
 * though syntactically correct, doesn't make sense.</a>
 */
public class RangeNotSatisfiableException extends AbstractusException {
    public RangeNotSatisfiableException(String message) {
        super(message, 416);
    }
}
