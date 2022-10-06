package abstractusAPI.http.request;

import abstractusAPI.http.query.Query;
import abstractusAPI.http.query.QueryURL;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the API.
 */
public class RequestFactory {

    private final OkHttpClient client = new OkHttpClient();
    private final UUID apiKey;

    private RequestValidator validator;

    protected RequestFactory(UUID apiKey) {
        this.apiKey = apiKey;
        this.validator = new BasicRequestValidator();
    }

    public void setRequestValidator(RequestValidator validator) {
        this.validator = validator;
    }

    public CompletableFuture<JSONObject> send(Query query) {
        Request request = new Request.Builder()
                .url(query.createRequest().addQueryParameter("key", apiKey.toString()).build())
                .build();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Response response = client.newCall(request).execute();
                if(validator.validate(response, new JSONObject(response.body().string()))) {
                    return new JSONObject(Objects.requireNonNull(response.body()).string());
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
