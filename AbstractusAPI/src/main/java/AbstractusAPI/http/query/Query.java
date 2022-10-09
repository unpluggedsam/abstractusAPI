package AbstractusAPI.http.query;

import java.net.URL;
import java.util.*;

import okhttp3.HttpUrl;
import okhttp3.Request;


/**
 * A request to a Web API.
 */
public class Query {

    private final List<Optional<QueryParameter>> queryParameterList = new ArrayList<>();
    private final URL url;

    /**
     * Begins building a new HTTP request that can be used to make the query.
     * <p>
     * The returned {@link HttpUrl.Builder builder} will always have at least its
     * <code>URL</code> configured, but may also include headers, a body, or
     * any other information relevant to the query.
     *
     * @return A minimally-configured HTTP request with only the information relevant to the query
     * itself.
     * @apiNote A builder is returned instead of a finalized {@link Request request} so that the
     * caller can attach any additional information it needs to the request, such as a user-agent or
     * API credentials.
     */
    public HttpUrl createRequest() {
        HttpUrl.Builder builder = Objects.requireNonNull(Objects.requireNonNull(HttpUrl.get(url))
                .newBuilder());
        queryParameterList.forEach(queryParameters -> queryParameters.ifPresent(param -> {
            builder.addQueryParameter(param.key(), param.value());
        }));
        return builder.build();
    }

    public Query(URL url) {
        this.url = url;
    }

    public void addParameter(QueryParameter... parameters) {
        Arrays.stream(parameters).sequential().forEach(param -> {
            queryParameterList.add(Optional.ofNullable(param));
        });
    }

    @Override
    public boolean equals(Object o) {

        if (getClass() != o.getClass()) {
            return false;
        }

        Query other = (Query) o;

        if (url.equals(other.url)) {
            if (queryParameterList.isEmpty() && other.queryParameterList.isEmpty()) {
                return true;
            }
            if (queryParameterList.isEmpty() || other.queryParameterList.isEmpty()) {
                return false;
            }

            return queryParameterList.equals(other.queryParameterList);
        } else {
            return false;
        }

    }
}