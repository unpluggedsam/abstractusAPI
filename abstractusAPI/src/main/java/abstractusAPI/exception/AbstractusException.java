package abstractusAPI.exception;

/**
 * An abstraction over all exceptions that can be returned from an API.
 */
public class AbstractusException extends RuntimeException {

    private final String message;

    public AbstractusException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "API exception: " + message;
    }
}
