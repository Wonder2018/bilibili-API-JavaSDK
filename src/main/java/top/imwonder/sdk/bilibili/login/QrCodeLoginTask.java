package top.imwonder.sdk.bilibili.login;

import java.awt.image.BufferedImage;

import top.imwonder.sdk.bilibili.domain.User;

/** 二维码登录任务接口 */
public interface QrCodeLoginTask {

    /**
     * 成功获取到二维码时执行。
     *
     * @param qrCode 二维码文件
     */
    public void ready(BufferedImage qrCode);

    /** 二维码被扫描时执行。 */
    public void scanned();

    /**
     * 成功登录时执行。
     *
     * @param user 已经登录的 {@link top.imwonder.sdk.bilibili.domain.User User} 对象
     */
    public void success(User user);

    /**
     * 异常处理
     *
     * @param e
     */
    public void onError(Exception e);
}
