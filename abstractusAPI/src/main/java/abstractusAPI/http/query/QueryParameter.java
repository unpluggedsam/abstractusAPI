package abstractusAPI.http.query;

/**
 * Keeps track of the parameters being passed into the request to the API.
 *
 * @param type  The key of the parameters being passed into the request.
 * @param value The value of the parameters being passed into the request.
 */

public record QueryParameter(QueryParameterTypes type, String value) {

    @Override
    public boolean equals(Object o) {

        if (getClass() != o.getClass()) {
            return false;
        }

        QueryParameter other = (QueryParameter) o;
        return type.equals(other.type()) && value.equals(other.value());
    }

}
