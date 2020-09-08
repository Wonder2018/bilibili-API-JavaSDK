/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:38
 * @Last Modified by: Wonder2019
 * @Last Modified time: 2020-09-06 15:53:48
 */
package top.imwonder.sdk.bilibili.login;

import static top.imwonder.sdk.bilibili.util.HttpRequestUtil.loadInfo;

import org.apache.http.client.methods.HttpGet;

import top.imwonder.sdk.bilibili.domain.AbstractPassport;
import top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo;
import top.imwonder.sdk.bilibili.domain.loginsimpleinfo.NavState;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;

public class SimpleLoginInfomation {

    public static final String FULL_INFO_API = "https://api.bilibili.com/x/web-interface/nav";
    public static final String PART_INFO_API = "https://account.bilibili.com/home/userInfo";
    public static final String NAV_STATE_API = "https://api.bilibili.com/x/web-interface/nav/sta";

    /**
     * 获取全部登录信息
     *
     * @param bilibiliAuth 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                     AbstractPassport}）
     * @return 用户信息（{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *         UserInfo}）
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                                    AbstractPassport} 未登录时抛出。
     */
    public static LoginUserInfo loadFullInfo(AbstractPassport bilibiliAuth) throws HttpRequestFailedException {
        HttpGet get = new HttpGet(FULL_INFO_API);
        HttpRequestUtil.setComonHeader(get);
        return loadInfo(bilibiliAuth, get);
    }

    /**
     * 获取全部登录信息,
     * 并填到传入的{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     * UserInfo}
     *
     * @param bilibiliAuth 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                     AbstractPassport}）
     * @param userInfo     要装载的
     *                     {@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *                     UserInfo}
     * @param isCover      是否覆盖原数据
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                                    AbstractPassport} 未登录时抛出。
     */
    public static void loadFullInfo(AbstractPassport bilibiliAuth, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        HttpGet get = new HttpGet(FULL_INFO_API);
        HttpRequestUtil.setComonHeader(get);
        userInfo.copyFrom(loadInfo(bilibiliAuth, get), isCover);
    }

    /**
     * 鼠标悬浮头像时展示的用户信息
     *
     * @param bilibiliAuth 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                     AbstractPassport}）
     * @return 用户信息（{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *         UserInfo}）
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                                    AbstractPassport} 未登录时抛出。
     */
    public static LoginUserInfo loadPartInfo(AbstractPassport bilibiliAuth) throws HttpRequestFailedException {
        HttpGet get = new HttpGet(PART_INFO_API);
        HttpRequestUtil.setComonHeader(get);
        return loadInfo(bilibiliAuth, get);
    }

    /**
     * 鼠标悬浮头像时展示的用户信息
     *
     * @param bilibiliAuth 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                     AbstractPassport}）
     * @param userInfo     要装载的
     *                     {@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *                     UserInfo}
     * @param isCover      是否覆盖原数据
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.AbstractPassport
     *                                    AbstractPassport} 未登录时抛出。
     */
    public static void loadPartInfo(AbstractPassport bilibiliAuth, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        HttpGet get = new HttpGet(PART_INFO_API);
        HttpRequestUtil.setComonHeader(get);
        userInfo.copyFrom(loadInfo(bilibiliAuth, get), isCover);
    }

    public static NavState loadNavState(AbstractPassport bilibiliAuth) throws HttpRequestFailedException {
        HttpGet get = new HttpGet(NAV_STATE_API);
        HttpRequestUtil.setComonHeader(get);
        return loadInfo(bilibiliAuth, get);
    }

    public static void loadNavState(AbstractPassport bilibiliAuth, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        NavState navState = userInfo.getNavState();
        HttpGet get = new HttpGet(NAV_STATE_API);
        HttpRequestUtil.setComonHeader(get);
        if (navState == null) {
            userInfo.setNavState(loadInfo(bilibiliAuth, get));
        } else {
            userInfo.getNavState().copyFrom(loadInfo(bilibiliAuth, get), isCover);
        }
    }

}
