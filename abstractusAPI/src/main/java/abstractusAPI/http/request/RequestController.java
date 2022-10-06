package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import abstractusAPI.http.query.QueryParameter;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Encapsulates requests to the API.
 */
public class RequestController {

    private final UUID apiKey;
    private final String origin;
    private final String hostname;
    private final RequestFactory requestFactory;

    public RequestController(UUID apiKey, String origin, String hostname) {
        this.apiKey = apiKey;
        this.origin = origin;
        this.hostname = hostname;
        this.requestFactory = new RequestFactory(apiKey);
    }

    public CompletableFuture<JSONObject> sendRequest(String endpoint, String parameterKey, String parameterValue) {
        try {
            URL url = new URL(origin, hostname, endpoint);
            QueryParameter params = new QueryParameter(parameterKey, parameterValue);
            Query query = new Query(url, params);
            return requestFactory.send(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delegates call to requestFactory.
     *
     * @param requestValidator The request validator that will be used to validate the request.
     */
    public void setRequestValidator(RequestValidator requestValidator) {
        requestFactory.setRequestValidator(requestValidator);
    }
}
