package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import abstractusAPI.http.query.QueryParameter;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
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

    public RequestController(String origin, String hostname, OkHttpClient client) {
        this.origin = origin;
        this.hostname = hostname;
        this.requestFactory = new RequestFactory(client);
    }

    public RequestController(String origin, String hostname, RequestValidator validator) {
        this.origin = origin;
        this.hostname = hostname;
        this.requestFactory = new RequestFactory(validator);
    }

    public RequestController(String origin, String hostname, OkHttpClient client, RequestValidator validator) {
        this.origin = origin;
        this.hostname = hostname;
        this.requestFactory = new RequestFactory(client, validator);
    }


    public CompletableFuture<JSONObject> sendRequestAsync(String endpoint, QueryParameter... params) {
        try {
            URL url = new URL(origin, hostname, "/" + endpoint);
            Query query = new Query(url);
            query.addParameter(params);
            query.addParameter(setAPIKeyIfPresent());
            return requestFactory.sendAsync(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<JSONObject> sendRequestAsync(String endpoint) {
        try {
            URL url = new URL(origin, hostname, "/" + endpoint);
            Query query = new Query(url);
            query.addParameter(setAPIKeyIfPresent());
            return requestFactory.sendAsync(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setApiKey(UUID apiKey) {
        this.apiKey = apiKey;
    }

    private QueryParameter setAPIKeyIfPresent() {
        if (apiKey != null) {
            return new QueryParameter("key", apiKey.toString());
        } else {
            return null;
        }
    }
}
