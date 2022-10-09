package AbstractusAPI.http.query;

/**
 * Keeps track of the parameters being passed into the request to the API.
 *
 * @param key  The key of the parameter being passed into the request.
 * @param value The value of the parameter being passed into the request.
 */

public record QueryParameter(String key, String value) {

    @Override
    public boolean equals(Object o) {

        if (getClass() != o.getClass()) {
            return false;
        }

        QueryParameter other = (QueryParameter) o;
        return key().equals(other.key()) && value().equals(other.value());
    }

}
