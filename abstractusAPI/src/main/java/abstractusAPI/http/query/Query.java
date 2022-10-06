package abstractusAPI.http.query;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;


/**
 * A request to a Web API.
 */
public class Query {

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private final Optional<QueryParameter[]> queryParameterList;
    private final QueryURL url;

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
    public HttpUrl.Builder createRequest() {
        HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.get(url.getURL())
                .newBuilder());
        queryParameterList.ifPresent(queryParameters -> Arrays.stream(queryParameters).toList()
                .forEach(parameter -> builder.addQueryParameter(parameter.key(),
                        parameter.value())));
        return builder;
    }

    public Query(QueryURL url, QueryParameter... queryParameterList) {
        this.queryParameterList = Optional.ofNullable(queryParameterList);
        this.url = url;
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

            return Arrays.equals(queryParameterList.get(), other.queryParameterList.get());
        } else {
            return false;
        }

    }
}