package top.imwonder.utiltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import top.imwonder.util.MessageUtil;

public class I18NTest {

    @Test
    public void testDefault() {
        System.out.println(MessageUtil.getMsg("error.unexpected"));
        assertEquals("this is test info!", MessageUtil.getMsg("test"));
    }
}
