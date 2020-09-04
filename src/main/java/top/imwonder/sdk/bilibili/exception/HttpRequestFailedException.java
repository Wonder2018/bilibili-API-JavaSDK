package top.imwonder.sdk.bilibili.exception;

public class HttpRequestFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HttpRequestFailedException(String msg) {
        super(msg);
    }

}
