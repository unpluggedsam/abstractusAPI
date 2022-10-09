package AbstractusAPI.http.request;

import AbstractusAPI.exception.client_error.*;
import AbstractusAPI.exception.server_error.*;
import AbstractusAPI.exception.server_error.HTTPVersionNotSupportedException;

import okhttp3.Response;
import org.json.JSONObject;

/**
 * Basic implementation of {@link RequestValidator}. Handles most
 * status codes that can be returned from an API.
 */
public class BasicRequestValidator implements RequestValidator {


    @Override
    public boolean validate(Response response, JSONObject returnObject) {
        if (response.isSuccessful()) {
            return true;
        } else {
            String failString = returnObject.getString("cause");

            switch (response.code()) {

                // client errors
                case 400 -> throw new BadRequestException(failString);
                case 401 -> throw new UnauthorizedException(failString);
                case 402 -> throw new PaymentRequiredException(failString);
                case 403 -> throw new ForbiddenException(failString);
                case 404 -> throw new NotFoundException(failString);
                case 405 -> throw new MethodNotAllowedException(failString);
                case 406 -> throw new NotAcceptableException(failString);
                case 407 -> throw new ProxyAuthenticationRequiredException(failString);
                case 408 -> throw new RequestTimeoutException(failString);
                case 409 -> throw new ConflictException(failString);
                case 410 -> throw new GoneException(failString);
                case 411 -> throw new LengthRequiredException(failString);
                case 412 -> throw new PreconditionFailedException(failString);
                case 413 -> throw new PayloadTooLargeException(failString);
                case 414 -> throw new URITooLongException(failString);
                case 415 -> throw new UnsupportedMediaTypeException(failString);
                case 416 -> throw new RangeNotSatisfiableException(failString);
                case 417 -> throw new ExpectationFailedException(failString);
                case 418 -> throw new TeapotException(failString);
                case 419 -> throw new MisdirectedRequestException(failString);
                case 422 -> throw new UnprocessableEntityException(failString);
                case 423 -> throw new LockedException(failString);
                case 424 -> throw new FailedDependencyException(failString);
                case 425 -> throw new TooEarlyException(failString);
                case 426 -> throw new UpgradeRequiredException(failString);
                case 428 -> throw new PreconditionRequiredException(failString);
                case 429 -> throw new RateLimitingException(failString);
                case 431 -> throw new RequestHeaderFieldsTooLargeException(failString);
                case 451 -> throw new UnavailableForLegalReasonsException(failString);

                // server errors
                case 500 -> throw new InternalServerErrorException(failString);
                case 501 -> throw new NotImplementedException(failString);
                case 502 -> throw new BadGatewayException(failString);
                case 503 -> throw new ServiceUnavailableException(failString);
                case 504 -> throw new GatewayTimeoutException(failString);
                case 505 -> throw new HTTPVersionNotSupportedException(failString);
                case 506 -> throw new VariantAlsoNegotiatesException(failString);
                case 507 -> throw new InsufficientStorageException(failString);
                case 508 -> throw new LoopDetectedException(failString);
                case 510 -> throw new NotExtendedException(failString);
                case 511 -> throw new NetworkAuthenticationException(failString);

                default -> {
                    return false;
                }

            }
        }
    }
}
