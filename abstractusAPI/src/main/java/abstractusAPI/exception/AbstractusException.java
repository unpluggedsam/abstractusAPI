package abstractusAPI.exception;

/**
 * An abstraction over all exceptions that can be returned from an API.
 * Keeps hold of the response string and status code returned from the API.
 */
public class AbstractusException extends RuntimeException {

    private final String message;

    private final int errorCode;

    public AbstractusException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "API error. Code: " + errorCode + ". Response: " + message;
    }
}
