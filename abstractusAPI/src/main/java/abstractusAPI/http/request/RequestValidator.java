package abstractusAPI.http.request;

import com.squareup.okhttp.Response;
import org.json.JSONObject;

public interface RequestValidator {
    boolean validate(Response response, JSONObject returnObject);
}
