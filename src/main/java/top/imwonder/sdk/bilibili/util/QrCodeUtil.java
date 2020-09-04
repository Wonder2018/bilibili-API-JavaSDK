package top.imwonder.sdk.bilibili.util;

import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QrCodeUtil {

    private QrCodeUtil() {
    }

    public static BufferedImage createQrCode(String text, int size) throws WriterException {
        int color0 = 0xff000000;
        int color1 = 0xffffffff;
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        return createQrCode(text, size, color1, color0, hints);
    }

    public static BufferedImage createQrCode(String text, int size, int color1, int color0,
            Map<EncodeHintType, ?> hints) throws WriterException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? color0 : color1);
            }
        }
        return image;
    }

}
