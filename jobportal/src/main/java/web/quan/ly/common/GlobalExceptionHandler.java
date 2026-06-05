package web.quan.ly.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ApiResponse<?>> handleAuthException(AuthException e) {
        ApiResponse<?> response = ApiResponse.error(e.getCode(), e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(ValidationException e) {
        ApiResponse<?> response = ApiResponse.error(e.getCode(), e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFoundException(NotFoundException e) {
        ApiResponse<?> response = ApiResponse.error(e.getCode(), e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<?>> handleAppException(AppException e) {
        ApiResponse<?> response = ApiResponse.error(e.getCode(), e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        String message = e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ApiResponse<?> response = ApiResponse.error(
                "VALIDATION_ERROR",
                message
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ApiResponse<?>> handleHttpMediaTypeNotAcceptableException(
            HttpMediaTypeNotAcceptableException e) {
        ApiResponse<?> response = ApiResponse.error(
                "NOT_ACCEPTABLE",
                "Client phai chap nhan response application/json"
        );

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        e.printStackTrace();

        ApiResponse<?> response = ApiResponse.error(
                "INTERNAL_ERROR",
                e.getClass().getSimpleName() + ": " + e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
