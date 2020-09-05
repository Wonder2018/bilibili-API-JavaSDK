package top.imwonder.sdk.bilibili.loginTest;

import static org.junit.Assert.assertEquals;

import com.google.zxing.WriterException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import top.imwonder.sdk.bilibili.enumeration.QrCodeStatus;
import top.imwonder.sdk.bilibili.login.QrCodeLogin;
import top.imwonder.sdk.bilibili.util.ConsoleQrCode;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;

public class QrCodeLoginTest {

    // @Test
    public void loginForPathTest() throws WriterException {
        QrCodeLogin qcl = new QrCodeLogin();
        qcl.loginForPath();
        // ConsoleQrCode.qrTest(path);
    }

    @Test
    public void checkStatusTest() throws Exception{
        System.out.println("打开登录好的Bilibili客户端，准备测试二维码登录！");
        System.out.println("还剩 5s 开始测试...");
        Thread.sleep(1000);
        System.out.println("还剩 4s 开始测试...");
        Thread.sleep(1000);
        System.out.println("还剩 3s 开始测试...");
        Thread.sleep(1000);
        System.out.println("还剩 2s 开始测试...");
        Thread.sleep(1000);
        System.out.println("还剩 1s 开始测试...");
        Thread.sleep(1000);
        QrCodeLogin qcl = new QrCodeLogin();
        String path = qcl.loginForPath();
        assertEquals(QrCodeStatus.WAITING_FOR_SCAN, qcl.refreshStatus());
        ConsoleQrCode.qrTest(path);
        System.out.println("打开bilibili客户端扫描二维码（不点击确认）!");
        System.out.println("等待扫描，还剩 5s...");
        Thread.sleep(1000);
        System.out.println("等待扫描，还剩 4s...");
        Thread.sleep(1000);
        System.out.println("等待扫描，还剩 3s...");
        Thread.sleep(1000);
        System.out.println("等待扫描，还剩 2s...");
        Thread.sleep(1000);
        System.out.println("等待扫描，还剩 1s...");
        Thread.sleep(1000);
        assertEquals(QrCodeStatus.WAITING_FOR_CONFIRM, qcl.refreshStatus());
        System.out.println("点击确认!");
        System.out.println("等待确认，还剩 5s...");
        Thread.sleep(1000);
        System.out.println("等待确认，还剩 4s...");
        Thread.sleep(1000);
        System.out.println("等待确认，还剩 3s...");
        Thread.sleep(1000);
        System.out.println("等待确认，还剩 2s...");
        Thread.sleep(1000);
        System.out.println("等待确认，还剩 1s...");
        Thread.sleep(1000);
        assertEquals(QrCodeStatus.SUCCESS, qcl.refreshStatus());
        System.out.println("测试完毕!");
        HttpGet get = new HttpGet("http://api.bilibili.com/x/web-interface/nav");
        HttpRequestUtil.setComonHeader(get);
        try (CloseableHttpResponse res = qcl.getUser().getClient().execute(get)) {
            System.out.println(EntityUtils.toString(res.getEntity()));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
