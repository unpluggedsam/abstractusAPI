package AbstractusAPI.http.request;

import AbstractusAPI.exception.AbstractusException;
import AbstractusAPI.exception.client_error.*;
import AbstractusAPI.exception.server_error.*;

import okhttp3.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic implementation of {@link RequestValidator}. Handles most
 * status codes that can be returned from an API.
 */
public class BasicRequestValidator implements RequestValidator {

    private static final Map<Integer, Class<? extends AbstractusException>> CLIENT_ERROR_MAP = new HashMap<>();
    private static final Map<Integer, Class<? extends AbstractusException>> SERVER_ERROR_MAP = new HashMap<>();

    static {
        // Client error mappings
        CLIENT_ERROR_MAP.put(400, BadRequestException.class);
        CLIENT_ERROR_MAP.put(401, UnauthorizedException.class);
        CLIENT_ERROR_MAP.put(402, PaymentRequiredException.class);
        CLIENT_ERROR_MAP.put(403, ForbiddenException.class);
        CLIENT_ERROR_MAP.put(404, NotFoundException.class);
        CLIENT_ERROR_MAP.put(405, MethodNotAllowedException.class);
        CLIENT_ERROR_MAP.put(406, NotAcceptableException.class);
        CLIENT_ERROR_MAP.put(407, ProxyAuthenticationRequiredException.class);
        CLIENT_ERROR_MAP.put(408, RequestTimeoutException.class);
        CLIENT_ERROR_MAP.put(409, ConflictException.class);
        CLIENT_ERROR_MAP.put(410, GoneException.class);
        CLIENT_ERROR_MAP.put(411, LengthRequiredException.class);
        CLIENT_ERROR_MAP.put(412, PreconditionFailedException.class);
        CLIENT_ERROR_MAP.put(413, PayloadTooLargeException.class);
        CLIENT_ERROR_MAP.put(414, URITooLongException.class);
        CLIENT_ERROR_MAP.put(415, UnsupportedMediaTypeException.class);
        CLIENT_ERROR_MAP.put(416, RangeNotSatisfiableException.class);
        CLIENT_ERROR_MAP.put(417, ExpectationFailedException.class);
        CLIENT_ERROR_MAP.put(418, TeapotException.class);
        CLIENT_ERROR_MAP.put(419, MisdirectedRequestException.class);
        CLIENT_ERROR_MAP.put(422, UnprocessableEntityException.class);
        CLIENT_ERROR_MAP.put(423, LockedException.class);
        CLIENT_ERROR_MAP.put(424, FailedDependencyException.class);
        CLIENT_ERROR_MAP.put(425, TooEarlyException.class);
        CLIENT_ERROR_MAP.put(426, UpgradeRequiredException.class);
        CLIENT_ERROR_MAP.put(428, PreconditionRequiredException.class);
        CLIENT_ERROR_MAP.put(429, RateLimitingException.class);
        CLIENT_ERROR_MAP.put(431, RequestHeaderFieldsTooLargeException.class);
        CLIENT_ERROR_MAP.put(451, UnavailableForLegalReasonsException.class);

        // Server error mappings
        SERVER_ERROR_MAP.put(500, InternalServerErrorException.class);
        SERVER_ERROR_MAP.put(501, NotImplementedException.class);
        SERVER_ERROR_MAP.put(502, BadGatewayException.class);
        SERVER_ERROR_MAP.put(503, ServiceUnavailableException.class);
        SERVER_ERROR_MAP.put(504, GatewayTimeoutException.class);
        SERVER_ERROR_MAP.put(505, HTTPVersionNotSupportedException.class);
        SERVER_ERROR_MAP.put(506, VariantAlsoNegotiatesException.class);
        SERVER_ERROR_MAP.put(507, InsufficientStorageException.class);
        SERVER_ERROR_MAP.put(508, LoopDetectedException.class);
        SERVER_ERROR_MAP.put(510, NotExtendedException.class);
        SERVER_ERROR_MAP.put(511, NetworkAuthenticationException.class);
    }

    @Override
    public boolean validate(Response response, JSONObject returnObject) {
        if (response.isSuccessful()) {
            return true;
        } else {
            String failString = returnObject.optString("cause", "Unknown error");
            int statusCode = response.code();

            if (CLIENT_ERROR_MAP.containsKey(statusCode)) {
                throwException(CLIENT_ERROR_MAP.get(statusCode), failString);
            } else if (SERVER_ERROR_MAP.containsKey(statusCode)) {
                throwException(SERVER_ERROR_MAP.get(statusCode), failString);
            } else {
                return false;
            }
        }
        return false;
    }

        private void throwException (Class <? extends AbstractusException> exceptionClass, String message){
            try {
                throw exceptionClass.getConstructor(String.class).newInstance(message);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to instantiate exception for status code", e);
            }
        }
    }
