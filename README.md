<p align="center">
    <img src="http://i0.hdslb.com/bfs/album/1ba8228cc208a12ac17f73a160081a0918ab7d14.png" width="250" height="200"/>
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

本项目为 [社会易姐 QwQ(SocialSisterYi)](https://github.com/SocialSisterYi) 所收集整理的 [Bilibili API](https://github.com/SocialSisterYi/bilibili-API-collect) 文档的 Java 封装。项目刚刚开始施工，还没有使用文档。如需了解 SDK 使用方法，请参考 Javadoc。

> **_注：_**
>
> **_1. 项目仅供研究学习使用，切勿滥用！_**
>
> **_2. 本 SDK 并非官方软件，不保证长期稳定性和可用性。只提供不定期修补维护。_**

---

计划整理分类&目录：

-   [ ] API 认证与鉴权
-   [ ] 图片格式化
-   [ ] 登录
    -   [x] 二维码登录
    -   [ ] 密码&短信登录
    -   [ ] qq&微博登录
    -   [ ] 登录基本信息
    -   [ ] 个人中心
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
    -   [ ] xml 实时弹幕
    -   [ ] xml 历史弹幕
    -   [ ] 快照
    -   [ ] 弹幕操作
    -   [ ] 高级弹幕
    -   [ ] 屏蔽管理
-   [ ] 专栏
    -   [ ] 分区
    -   [ ] 基本信息
    -   [ ] 点赞&投币&收藏
    -   文集基本信息
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
    -   [ ] 热搜
    -   [ ] 搜索建议
-   [ ] 小黑屋
    -   [ ] 基本信息
    -   [ ] 封禁公示
    -   [ ] 仲裁信息
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
-   [ ] 实时广播
    -   [ ] 总则
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
    -   [直播分区
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
    -   [ ] 分区在线人数

<img src="http://www.imwonder.top/assets/img/index/face.webp" />

**--by [Wonder2020](http://www.imwonder.top)**

**相关项目**：

库及文档：

**https://github.com/SocialSisterYi/bilibili-API-collect** **!trunk**

https://github.com/jingyuexing/bilibiliAPI

https://github.com/fython/BilibiliAPIDocs

https://github.com/czp3009/bilibili-api

https://github.com/Vespa314/bilibili-api

https://github.com/Hsury/Bilibili-Toolkit

https://github.com/adachi-sakura/openbilibili-go-common-1

成品：

https://github.com/zyzsdy/biliroku

https://github.com/bilibili-helper/bilibili-helper-o

https://github.com/apachecn/BiliDriveEx

https://github.com/apachecn/CDNDrive

https://github.com/Hsury/BiliDrive

https://github.com/Tsuk1ko/bilibili-live-chat

其他：

https://github.com/Hsury/Geetest3-Crack

https://github.com/SocialSisterYi/bv2av_convert
