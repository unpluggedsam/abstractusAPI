package abstractusAPI.exception.client_error;

import abstractusAPI.exception.AbstractusException;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/402">This response code is reserved for future use. The initial aim
 * for creating this code was using it for digital payment systems, however this status code is used very rarely and no standard convention exists.</a>
 */
public class PaymentRequiredException extends AbstractusException {
    public PaymentRequiredException(String message) {
        super(message, 402);
    }
}
