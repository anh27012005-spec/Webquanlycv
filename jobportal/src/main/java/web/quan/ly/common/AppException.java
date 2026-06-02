package web.quan.ly.common;

public class AppException extends RuntimeException {
    private String code;
    private int statusCode;

    public AppException(String message) {
        super(message);
        this.code = "ERROR";
        this.statusCode = 500;
    }

    public AppException(String code, String message) {
        super(message);
        this.code = code;
        this.statusCode = 500;
    }

    public AppException(String code, String message, int statusCode) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
