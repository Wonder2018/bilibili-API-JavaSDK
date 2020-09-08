<p align="center">
    <img src="https://i0.hdslb.com/bfs/album/1ba8228cc208a12ac17f73a160081a0918ab7d14.png" width="250" height="200"/>
<p/>
<h1 align="center">哔哩哔哩API - JavaSDK</h1>
<p align="center">
    <a href="https://github.com/Wonder2018/bilibili-API-JavaSDK/issues" style="text-decoration:none">
        <img src="https://img.shields.io/github/issues/Wonder2018/bilibili-API-JavaSDK.svg" alt="GitHub issues"/>
    </a>
    <a href="https://github.com/Wonder2018/bilibili-API-JavaSDK/stargazers" style="text-decoration:none" >
        <img src="https://img.shields.io/github/stars/Wonder2018/bilibili-API-JavaSDK.svg" alt="GitHub stars"/>
    </a>
    <a href="https://github.com/Wonder2018/bilibili-API-JavaSDK/network" style="text-decoration:none" >
        <img src="https://img.shields.io/github/forks/Wonder2018/bilibili-API-JavaSDK.svg" alt="GitHub forks"/>
    </a>
    <a href="https://github.com/Wonder2018/bilibili-API-JavaSDK/blob/master/LICENSE" style="text-decoration:none" >
        <img src="https://img.shields.io/github/license/Wonder2018/bilibili-API-JavaSDK.svg" alt="GitHub license"/>
    </a>
</p>

本项目为 [社会易姐 QwQ(SocialSisterYi)](https://github.com/SocialSisterYi) 所收集整理的 [Bilibili API](https://github.com/SocialSisterYi/bilibili-API-collect) 文档的 Java 封装。项目使用 OracleJDK1.8 开发，使用 Maven 编译和管理依赖。开始施工不久，还没有使用文档。如需了解 SDK 使用方法，请参考 Javadoc。

> **_注：_**
>
> **_1. 项目仅供研究学习使用，切勿滥用！_**
>
> **_2. 本 SDK 并非官方软件，不保证长期稳定性和可用性。只提供不定期修补维护。_**

---

### 计划整理分类&目录：

-   [ ] API 认证与鉴权
-   [ ] 公共错误码
-   [ ] 图片格式化
-   [ ] 登录操作
    -   [ ] 登录
    -   -   [x] 人机认证
        -   [x] 短信登录
        -   [ ] 密码登录
        -   [x] 二维码登录
        -   [ ] SNS 登录（qq&微博）
    -   [x] 登录基本信息
    -   [ ] 个人中心
    -   [ ] 注销
-   [ ] 消息中心
    -   [ ] 通知类消息
    -   [ ] 私信
    -   [ ] 设置
-   [ ] 用户
    -   [ ] 基本信息
    -   [ ] 状态数
    -   [ ] 关系
    -   [ ] 个人空间
    -   [ ] 检查昵称是否可注册
-   [ ] 视频
    -   [ ] 视频分区一览（分区代码）
    -   [ ] 基本信息
    -   [ ] 状态数
    -   [ ] 快照
    -   [ ] 点赞&投币&收藏
    -   [ ] TAG
    -   [ ] 视频推荐
    -   [ ] 播放&下载地址（视频流）
    -   [ ] 互动视频
    -   [ ] 高能进度条
    -   [ ] 信息上报（心跳及记录历史）
-   [ ] 番剧（影视）
    -   [ ] 基本信息
    -   [ ] 状态数
    -   [ ] 操作
-   [ ] 视频弹幕
    -   [ ] protobuf 实时弹幕
    -   [ ] protobuf 云推荐弹幕
    -   [ ] xml 实时弹幕
    -   [ ] xml 历史弹幕
    -   [ ] 快照
    -   [ ] 弹幕操作
    -   [ ] 高级弹幕
    -   [ ] 屏蔽弹幕
    -   [ ] 智能防挡弹幕
-   [ ] 专栏
    -   [ ] 分区
    -   [ ] 基本信息
    -   [ ] 点赞&投币&收藏
    -   [ ] 文集基本信息
-   [ ] 音频
    -   [ ] 歌曲基本信息
    -   [ ] 歌单&音频收藏夹详细信息
    -   [ ] 状态数
    -   [ ] 投币&收藏
    -   [ ] 播放&下载地址（音频流）
    -   [ ] 音频榜单
-   [ ] 排行榜&最新动态
    -   [ ] 排行榜
    -   [ ] 最新动态
-   [ ] 搜索
    -   [ ] 搜索请求
    -   [ ] 搜索结果
    -   [ ] 默认搜索&热搜
    -   [ ] 搜索建议
-   [ ] 小黑屋
    -   [ ] 基本信息
    -   [ ] 封禁公示
    -   [ ] 风纪委员及众裁案件相关
        -   [ ] 风纪委员基本信息
        -   [ ] 众裁案件基本信息
        -   [ ] 裁决操作
-   [ ] 评论区
    -   [ ] 评论区明细
    -   [ ] 操作
-   [ ] 表情
    -   [ ] 表情及表情包信息
    -   [ ] 操作
-   [ ] 创作中心
    -   [ ] 统计与数据
    -   [ ] 列表查询相关
    -   [ ] 电磁力数据
-   [ ] 实时广播（通讯协议）
    -   [ ] 视频内广播
-   [ ] 充电
    -   [ ] B 币方式
    -   [ ] 微信&支付宝方式
    -   [ ] 充电留言
    -   [ ] 充电列表
-   [ ] 动态
    -   [ ] 发送&转载动态
    -   [ ] 动态列表
    -   [ ] 动态内容
    -   [ ] 小视频
    -   [ ] 操作
-   [ ] 历史记录&稍后再看
    -   [ ] 历史记录
    -   [ ] 稍后再看
-   [ ] 收藏夹
-   [ ] 课程
    -   [ ] 课程基本信息
    -   [ ] 已购课程
    -   [ ] 分区推荐列表
    -   [ ] 操作
    -   [ ] 播放&下载地址（视频流）
-   [ ] 直播
    -   [ ] 直播间基本信息
    -   [ ] 直播分区
    -   [ ] 直播间管理
    -   [ ] 直播间操作
    -   [ ] 直播视频流
    -   [ ] 直播信息流
-   [ ] 答题
-   [ ] B 币钱包
    -   [ ] 基本信息
    -   [ ] B 币充值
    -   [ ] 贝壳相关
-   [ ] 哔哩哔哩漫画
-   [ ] 哔哩哔哩游戏
-   [ ] 轻视频
-   [ ] 其他
    -   [ ] 基于 ip 的地理位置查询
    -   [ ] 获取当前时间戳
-   [ ] web 端组件
    -   [ ] 分区当日上传数
-   [ ] APP 端组件
    -   [ ] 开屏图片
-   [ ] 个性装扮
    -   [ ] 主题及加载动画
    -   [ ] 主题色

---

### 使用方法

1. 下载安装

    ```bash
    # 创建临时文件夹
    mkdir temp
    cd temp

    # 克隆相关代码
    git clone https://github.com/Wonder2018/imwonder-util.git
    git clone https://github.com/Wonder2018/bilibili-API-JavaSDK.git

    # 编译安装
    cd imwonder-util
    mvn install
    cd ../bilibili-API-JavaSDK
    mvn install

    ```

2. 在 pom.xml 中配置依赖

    ```xml

    <!-- bilibili JavaSDK -->
    <dependency>
        <groupId>top.imwonder.sdk.bilibili</groupId>
        <artifactId>bilibili-API-JavaSDK</artifactId>
        <version>1.0.0</version>
    </dependency>

    ```

---

### 关于暂未完成封装的部分

目前通用接口请求方案已经成功制定，可以完成大部分的 json 数据请求。但由于实体封装工作量太大，还无法完整实现调用，如需使用还未完成封装的 API 可以自行建立消息实体并继承 [top.imwonder.sdk.bilibili.domain.AbstractData](https://github.com/Wonder2018/bilibili-API-JavaSDK/blob/master/src/main/java/top/imwonder/sdk/bilibili/domain/AbstractData.java) 来实现简单迅速的封装，具体方法如下。（有意一起封装的可联系[wonder2020](mailto:wonder6613@126.com)获取本人常用联系方式并了解更多封装规范或直接提issue，也可直接提交 pr）

1. 实体类编写注意事项：

    1. 目前可以正常处理返回格式如下的 json：

        ```json
        {
            "code": 0,
            "message": "msg",
            "ttl": 1,
            "data": {}
        }
        ```

    2. 返回体根节点中可以有其他字段或缺少某些字段，但目前只处理以上四个字段，缺少的字段在实体中自动设为`null`。
    3. 这里要求建立的实体是指 `data` 中的内容。
    4. 自行建立的实体需要继承 [top.imwonder.sdk.bilibili.domain.AbstractData](https://github.com/Wonder2018/bilibili-API-JavaSDK/blob/master/src/main/java/top/imwonder/sdk/bilibili/domain/AbstractData.java)以便统一管理。
    5. 项目使用 Lombok 自动生成实体相关方法，实体类不需要自行建立`getter`和`setter`方法，只需在类的声明上加入`@Data`和`@EqualsAndHashCode(callSuper = false)`两个注解。
    6. 实体中所有成员变量均需设为私有成员，并使用驼峰命名。若 json 返回体中的字段不是驼峰命名需在对应成员的声明上加`@SerializedName("json_key")`注解 "json_key" 替换为当前成员在 json 返回体中的字段名。
    7. 涉及日期的实体如需将日期字符串转化为`java.util.Date`对象，须在类的声明上加`@JsonAdapter(value = AbstractDataDateFormatConfig.class)`注解，并在相应字段的声明上加`@JsonDateFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")`注解，并自行匹配日期格式，暂不支持时间戳转换。
    8. [top.imwonder.sdk.bilibili.domain.AbstractData](https://github.com/Wonder2018/bilibili-API-JavaSDK/blob/master/src/main/java/top/imwonder/sdk/bilibili/domain/AbstractData.java) 提供方法 `public void copyFrom(AbstractData obj, boolean isCover)`,可将任何实体中的同名属性以浅拷贝的形式拷贝至当前实体。第二个参数可用于决定是否要覆盖本实体中的非`null`值。

2. 请求 API 和实体的使用。

    封装好实体后请求 API 的代码会非常简洁，下面将举例说明

    ```java
    // 此处只展示写法，具体方法的作用及参数和返回值意义可在IDE中将鼠标悬浮至方法名上，查看显示的Javadoc
    URIBuilder uri = new URIBuilder(); // 构建URI
    uri.setPath("https://www.example.com"); // 设置API地址
    uri.setParameter("oauthKey", oauthKey); // 添加参数
    HttpPost post = null; // 构建请求（注意对应API的请求方法）
    try {
        post = new HttpPost(uri.build());
    } catch (URISyntaxException e) {
        log.info(MessageUtil.getMsg("error.unexpected"));
        log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
    }
    HttpRequestUtil.setComonHeader(post); // 插入通用请求头
    Domain result = null; // 声明实体
    try{
        result = HttpRequestUtil.loadInfo(post);
    }catch(HttpRequestFailedException e){
        // 请求错误请检查参数配置或实体封装是否正确。
    }
    ```
    > 注：如果请求需要登陆的API，以上try语句块中请使用`post = new HttpPost(user, uri.build());`，其中`user`为成功登录的用户对象，登录方法可参考[top.imwonder.sdk.bilibili.loginTest.QrCodeLoginTest](https://github.com/Wonder2018/bilibili-API-JavaSDK/blob/master/src/test/java/top/imwonder/sdk/bilibili/loginTest/QrCodeLoginTest.java)，也可阅读登录相关代码的javadoc。

教程先写这么多了，之后慢慢补。（有意一起封装的可联系[wonder2020](mailto:wonder6613@126.com)获取本人常用联系方式并了解更多封装规范或直接提issue，也可直接提交 pr）

---

<img src="http://www.imwonder.top/assets/img/index/face.webp" />

**Powered with ❤ by [Wonder2020](http://www.imwonder.top)**

### 相关项目

1. 库及文档：

    **https://github.com/SocialSisterYi/bilibili-API-collect** **!trunk**

    https://github.com/jingyuexing/bilibiliAPI

    https://github.com/fython/BilibiliAPIDocs

    https://github.com/czp3009/bilibili-api

    https://github.com/Vespa314/bilibili-api

    https://github.com/Hsury/Bilibili-Toolkit

    https://github.com/whjstc/openbilibili-go-common-1

    https://github.com/wnstar/bili-utils

    https://github.com/lovelyyoshino/Bilibili-Live-API

    https://github.com/flaribbit/bilibili-manga-spider

    https://github.com/simon300000/bili-api

2. 成品：

    https://github.com/3Shain/BiliChat

    https://github.com/AncientLysine/BiliLocal

    https://github.com/zyzsdy/biliroku

    https://github.com/otakustay/danmaku-to-ass

    https://github.com/bilibili-helper/bilibili-helper-o

    https://github.com/apachecn/BiliDriveEx

    https://github.com/apachecn/CDNDrive

    https://github.com/Hsury/BiliDrive

    https://github.com/Tsuk1ko/bilibili-live-chat

    https://github.com/ironmanic/crawler_target_users_good

    https://github.com/dd-center/DDatElectron

    https://github.com/dd-center/vtbs.moe

3. 其他：

    https://github.com/kuresaru/geetest-validator

    https://github.com/Hsury/Geetest3-Crack

    https://github.com/SocialSisterYi/bv2av_convert
