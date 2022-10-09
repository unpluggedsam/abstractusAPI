package AbstractusAPI.http.request;

import AbstractusAPI.http.query.Query;
import AbstractusAPI.http.query.QueryParameter;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Encapsulates requests to the API.
 */
public class RequestController {

    private final List<QueryParameter> queryParameters = new ArrayList<>();
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
            query.addParameter(queryParameters.toArray(new QueryParameter[queryParameters.size()]));
            return requestFactory.sendAsync(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<JSONObject> sendRequestAsync(String endpoint) {
        try {
            URL url = new URL(origin, hostname, "/" + endpoint);
            Query query = new Query(url);
            query.addParameter(queryParameters.toArray(new QueryParameter[queryParameters.size()]));
            return requestFactory.sendAsync(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearCache() {
        requestFactory.clearCache();
    }

    public void setApiKey(UUID apiKey) {
        addPermanentQueryParameter(new QueryParameter("key", apiKey.toString()));
    }

    /**
     * Adds a parameter to every request being made.
     * @param parameter The parameter to add.
     */
    public void addPermanentQueryParameter(QueryParameter parameter) {
        queryParameters.add(parameter);
    }

    public void removePermanentQueryParameter(QueryParameter parameter) {
        queryParameters.remove(parameter);
    }
}
