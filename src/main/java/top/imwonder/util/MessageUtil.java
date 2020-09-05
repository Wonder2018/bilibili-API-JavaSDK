package top.imwonder.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {

    private static ResourceBundle rb = ResourceBundle.getBundle("i18n.message");

    private MessageUtil() {
    }

    public static String getMsg(String key, Object... args) {
        if(args.length ==0){
            return rb.getString(key);
        }
        return MessageFormat.format(rb.getString(key), args);
    }
}
