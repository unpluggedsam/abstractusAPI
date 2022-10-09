package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/406"> This response is sent when the web server, after performing server-driven content negotiation,
 * doesn't find any content that conforms to the criteria given by the user agent. </a>
 */
public class NotAcceptableException extends AbstractusException  {
    public NotAcceptableException(String message) {
        super(message, 406);
    }
}
