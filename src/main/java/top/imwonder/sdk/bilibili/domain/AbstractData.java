/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:19:51
 * @Last Modified by:   Wonder2019
 * @Last Modified time: 2020-09-06 14:19:51
 */
package top.imwonder.sdk.bilibili.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.util.MessageUtil;
import top.imwonder.util.StringUtil;

@Slf4j
public class AbstractData {
    public void copyFrom(AbstractData obj, boolean isCover) {
        Class<?> currentClass = getClass();
        Class<?> objClass = obj.getClass();
        Field fields[] = currentClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = StringUtil.upperFirstChar(field.getName());
                String getterName = String.format("get%s", fieldName);
                if ("Log".equals(fieldName)) {
                    continue;
                }
                try {
                    Method currentGetter = currentClass.getMethod(getterName);
                    Method objGetter = objClass.getMethod(getterName);
                    Object currentValue = currentGetter.invoke(this);
                    Object objValue = objGetter.invoke(obj);
                    if (isCover || (currentValue == null && objValue != null)) {
                        Method setter = objClass.getMethod(String.format("set%s", fieldName), field.getType());
                        setter.invoke(this, objValue);
                    }
                } catch (NoSuchMethodException e) {
                    continue;
                }
                field.setAccessible(false);
            }
        } catch (Exception e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            e.printStackTrace();
        }
    }
}
