/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:38
 * @Last Modified by: Wonder2019
 * @Last Modified time: 2020-09-06 15:53:48
 */
package top.imwonder.sdk.bilibili.login;

import static top.imwonder.sdk.bilibili.util.HttpRequestUtil.loadInfo;

import top.imwonder.sdk.bilibili.domain.User;
import top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo;
import top.imwonder.sdk.bilibili.domain.loginsimpleinfo.NavState;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;

public class SimpleLoginInfomation {

    public static final String FULL_INFO_API = "https://api.bilibili.com/x/web-interface/nav";
    public static final String PART_INFO_API = "https://account.bilibili.com/home/userInfo";
    public static final String NAV_STATE_API = "https://api.bilibili.com/x/web-interface/nav/sta";

    /**
     * 获取全部登录信息
     *
     * @param user 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.User User}）
     * @return 用户信息（{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *         UserInfo}）
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.User
     *                                    User} 未登录时抛出。
     */
    public static LoginUserInfo loadFullInfo(User user) throws HttpRequestFailedException {
        return loadInfo(user, FULL_INFO_API);
    }

    /**
     * 获取全部登录信息,
     * 并填到传入的{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     * UserInfo}
     *
     * @param user     已登录的用户（{@link top.imwonder.sdk.bilibili.domain.User User}）
     * @param userInfo 要装载的
     *                 {@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *                 UserInfo}
     * @param isCover  是否覆盖原数据
     * @throws HttpRequestFailedException传入的 {@link top.imwonder.sdk.bilibili.domain.User
     *                                       User} 未登录时抛出。
     */
    public static void loadFullInfo(User user, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        userInfo.copyFrom(loadInfo(user, FULL_INFO_API), isCover);
    }

    /**
     * 鼠标悬浮头像时展示的用户信息
     *
     * @param user 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.User User}）
     * @return 用户信息（{@link top.imwonder.sdk.bilibili.domain.loginsimpleinfo.LoginUserInfo
     *         UserInfo}）
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.User
     *                                    User} 未登录时抛出。
     */
    public static LoginUserInfo loadPartInfo(User user) throws HttpRequestFailedException {
        return loadInfo(user, PART_INFO_API);
    }

    /**
     * 鼠标悬浮头像时展示的用户信息
     *
     * @param user 已登录的用户（{@link top.imwonder.sdk.bilibili.domain.User User}）
     * @throws HttpRequestFailedException 传入的
     *                                    {@link top.imwonder.sdk.bilibili.domain.User
     *                                    User} 未登录时抛出。
     */
    public static void loadPartInfo(User user, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        userInfo.copyFrom(loadInfo(user, PART_INFO_API), isCover);
    }

    public static NavState loadNavState(User user) throws HttpRequestFailedException {
        return loadInfo(user, NAV_STATE_API);
    }

    public static void loadNavState(User user, LoginUserInfo userInfo, boolean isCover)
            throws HttpRequestFailedException {
        NavState navState = userInfo.getNavState();
        if (navState == null) {
            userInfo.setNavState(loadInfo(user, NAV_STATE_API));
        } else {
            userInfo.getNavState().copyFrom(loadInfo(user, NAV_STATE_API), isCover);
        }
    }

}
