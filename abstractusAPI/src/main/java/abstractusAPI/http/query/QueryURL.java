package abstractusAPI.http.query;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Keeps track of the URL being passed to the API.
 */
public record QueryURL(String origin, String hostname, String endpoint) {

    public URL getURL() {
        try {
            return new URL(origin, hostname, endpoint);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
