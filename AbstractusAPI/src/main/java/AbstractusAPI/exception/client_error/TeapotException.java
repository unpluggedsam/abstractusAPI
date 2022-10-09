package AbstractusAPI.exception.client_error;

import AbstractusAPI.exception.AbstractusException;

/**
 * <a href = "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/418">The HTTP 418 I'm a teapot client error response code indicates
 * that the server refuses to brew coffee because it is, permanently, a teapot. A combined coffee/tea pot that is temporarily out of coffee should
 * instead return 503. This error is a reference to Hyper Text Coffee Pot Control Protocol defined in April Fools' jokes in 1998 and 2014.</a>
 */
public class TeapotException extends AbstractusException {
    public TeapotException(String message) {
        super(message, 418);
    }
}
