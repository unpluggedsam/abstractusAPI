package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the API.
 */
public class RequestFactory {

    private final OkHttpClient client = new OkHttpClient();
    private RequestValidator validator;

    protected RequestFactory() {
        this.validator = new BasicRequestValidator();
    }

    public void setRequestValidator(RequestValidator validator) {
        this.validator = validator;
    }

    /**
     * Sends a request to the API. Processes the results asynchronously.
     * @param query The {@link Query} containing all information about the request.
     * @return A {@link CompletableFuture} containing a {@link JSONObject} with the returned data.
     */
    public CompletableFuture<JSONObject> sendAsync(Query query) {
        Request request = new Request.Builder().url(query.createRequest().build()).build();

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
