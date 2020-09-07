/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:34
 * @Last Modified by:   Wonder2019
 * @Last Modified time: 2020-09-06 14:20:34
 */
package top.imwonder.sdk.bilibili.login;

import java.awt.image.BufferedImage;

import top.imwonder.sdk.bilibili.domain.AbstractPassport;

/** 二维码登录任务接口 */
public interface QrCodeLoginTask<T extends AbstractPassport> {

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
     * @param bilibiliAuth 已经登录的 {@link top.imwonder.sdk.bilibili.domain.User User} 对象
     */
    public void success(T bilibiliAuth);

    /**
     * 异常处理
     *
     * @param e
     */
    public void onError(Exception e);
}
