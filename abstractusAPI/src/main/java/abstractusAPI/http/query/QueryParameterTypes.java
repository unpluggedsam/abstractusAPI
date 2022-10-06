package abstractusAPI.http.query;

/**
 * Used as an abstraction over query parameters.
 * The user should create an enum that implements this interface
 * and then create values for their own query parameters.
 */
public interface QueryParameterTypes {
    String getKey();
}
