package top.imwonder.sdk.bilibili.exception;

public class BadResultException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BadResultException(String msg) {
        super(msg);
    }

}
