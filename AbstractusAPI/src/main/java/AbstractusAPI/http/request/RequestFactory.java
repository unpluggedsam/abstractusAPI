package AbstractusAPI.http.request;

import AbstractusAPI.cache.CacheInterceptor;
import AbstractusAPI.http.query.Query;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Sends requests to the API.
 */
public class RequestFactory {

    private final OkHttpClient client;
    private final RequestValidator validator;
    private boolean autoClearCache;

    protected RequestFactory() {
        this.validator = new BasicRequestValidator();
        this.client = getClient();
    }

    protected RequestFactory(OkHttpClient client) {
        this.client = client;
        this.validator = new BasicRequestValidator();
    }

    protected RequestFactory(RequestValidator validator) {
        this.validator = validator;
        this.client = getClient();
    }

    protected RequestFactory(OkHttpClient client, RequestValidator validator) {
        this.client = client;
        this.validator = validator;
    }

    protected void setAutoClearCache(boolean autoClear) {
        this.autoClearCache = autoClear;
    }

    private OkHttpClient getClient() {
        File httpCacheDirectory = new File("./cacheDir", "http-cache");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new CacheInterceptor())
                .cache(cache)
                .build();
    }

    public void clearCache() {
        try {
            Objects.requireNonNull(client.cache()).evictAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Sends a request to the API. Processes the results asynchronously.
     *
     * @param query The {@link Query} containing all information about the request.
     * @return A {@link CompletableFuture} containing a {@link JSONObject} with the returned data.
     */
    public CompletableFuture<JSONObject> sendAsync(Query query) {
        Request request = new Request.Builder().url(query.createRequest()).build();

        if(autoClearCache) clearCache();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Response response = client.newCall(request).execute();
                JSONObject object = new JSONObject(response.body().string());
                if (validator.validate(response, object)) {
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
