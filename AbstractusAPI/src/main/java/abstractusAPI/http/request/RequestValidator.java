package abstractusAPI.http.request;

import okhttp3.Response;
import org.json.JSONObject;

/**
 * Validates requests from an API.
 * A basic implementation is provided but if the end user
 * would like to handle specific status codes with their own errors
 * they may use the setRequestValidator() method in the {@link RequestController} class.
 */
public interface RequestValidator {
    boolean validate(Response response, JSONObject returnObject);
}
