package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import abstractusAPI.http.query.QueryParameter;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Encapsulates requests to the API.
 */
public class RequestController {

    private UUID apiKey;
    private final String origin;
    private final String hostname;
    private final RequestFactory requestFactory;

    public RequestController(String origin, String hostname) {
        this.origin = origin;
        this.hostname = hostname;
        this.requestFactory = new RequestFactory();
    }

    public CompletableFuture<JSONObject> sendRequest(String endpoint, QueryParameter... params) {
        try {
            URL url = new URL(origin, hostname, endpoint);
            Query query = new Query(url);
            query.addParameter(params);
            query.addParameter(setAPIKeyIfPresent());
            return requestFactory.send(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<JSONObject> sendRequest(String endpoint) {
        try {
            URL url = new URL(origin, hostname, endpoint);
            Query query = new Query(url);
            query.addParameter(setAPIKeyIfPresent());
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

    public void setApiKey(UUID apiKey) {
        this.apiKey = apiKey;
    }

    private QueryParameter setAPIKeyIfPresent() {
        if(apiKey != null) {
            return new QueryParameter("key", apiKey.toString());
        } else {
            return null;
        }
    }
}
