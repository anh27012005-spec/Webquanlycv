package web.quan.ly.common;

public class ValidationException extends AppException {
    public ValidationException(String message) {
        super("VALIDATION_ERROR", message, 400);
    }

    public ValidationException(String code, String message) {
        super(code, message, 400);
    }
}
