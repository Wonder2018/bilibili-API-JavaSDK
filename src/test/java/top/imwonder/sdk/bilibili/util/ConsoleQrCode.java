package top.imwonder.sdk.bilibili.util;

import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class ConsoleQrCode {
    public static void qrTest(String text) throws WriterException {
        int size = 48;
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        for (int i = 0; i < size; i++) {
            System.out.print("      ");
            for (int j = 0; j < size; j++) {
                if (!bitMatrix.get(i, j)) {
                    System.out.print("\u25A0\u25A0");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
