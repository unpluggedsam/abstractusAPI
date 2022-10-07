package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the API.
 */
public class RequestFactory {

    private OkHttpClient client;
    private RequestValidator validator;

    protected RequestFactory() {
        this.validator = new BasicRequestValidator();
    }

    public void setRequestValidator(RequestValidator validator) {
        this.validator = validator;
        client = new OkHttpClient();
    }

    /**
     * Sends a request to the API. Processes the results asynchronously.
     * @param query The {@link Query} containing all information about the request.
     * @return A {@link CompletableFuture} containing a {@link JSONObject} with the returned data.
     */
    public CompletableFuture<JSONObject> sendAsync(Query query) {
        Request request = new Request.Builder().url(query.createRequest()).build();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Response response = client.newCall(request).execute();
                JSONObject object = new JSONObject(response.body().string());
                if(validator.validate(response, object)) {
                    return object;
                } else {
                    CompletableFuture.failedFuture(new Throwable("Failure"));
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        });
    }
}
