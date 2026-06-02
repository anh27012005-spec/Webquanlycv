package web.quan.ly.common;

public class NotFoundException extends AppException {
    public NotFoundException(String message) {
        super("NOT_FOUND", message, 404);
    }

    public NotFoundException(String resource, Integer id) {
        super("NOT_FOUND", resource + " with id " + id + " not found", 404);
    }
}
