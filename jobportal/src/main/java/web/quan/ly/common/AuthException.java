package web.quan.ly.common;

public class AuthException extends AppException {
    public AuthException(String message) {
        super("AUTH_ERROR", message, 401);
    }

    public AuthException(String code, String message) {
        super(code, message, 401);
    }
}
