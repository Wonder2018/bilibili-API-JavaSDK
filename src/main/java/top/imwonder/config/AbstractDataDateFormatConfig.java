/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:19:29
 * @Last Modified by: Wonder2019
 * @Last Modified time: 2020-09-06 14:31:45
 */
package top.imwonder.config;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.annotations.JsonDateFormat;
import top.imwonder.sdk.bilibili.domain.AbstractData;
import top.imwonder.util.MessageUtil;

@Slf4j
public class AbstractDataDateFormatConfig<T extends AbstractData> implements JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        Class<?> clazz = (Class<?>) typeOfSrc;
        Field fields[] = clazz.getDeclaredFields();
        JsonObject jo = new JsonObject();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                if ("Log".equals(fieldName)) {
                    continue;
                }
                JsonDateFormat jdf = field.getAnnotation(JsonDateFormat.class);
                SerializedName sn = field.getAnnotation(SerializedName.class);
                fieldName = sn == null ? fieldName : sn.value();
                Object value = field.get(src);
                if (jdf == null || !(value instanceof Date)) {
                    jo.add(fieldName, context.serialize(value, field.getType()));
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat(jdf.pattern());
                    sdf.setTimeZone(TimeZone.getTimeZone(jdf.timezone()));
                    jo.addProperty(fieldName, sdf.format(value));
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                log.info(MessageUtil.getMsg("error.unexpected"));
                log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            } finally {
                field.setAccessible(false);
            }
        }
        return jo;
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) typeOfT;
        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            throw new JsonParseException(e.getMessage());
        }
        JsonObject jo = json.getAsJsonObject();
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                if ("Log".equals(fieldName)) {
                    continue;
                }
                JsonDateFormat jdf = field.getAnnotation(JsonDateFormat.class);
                SerializedName sn = field.getAnnotation(SerializedName.class);
                fieldName = sn == null ? fieldName : sn.value();
                JsonElement value = jo.get(fieldName);
                if (value == null) {
                    continue;
                }
                if (jdf == null || field.getType() != Date.class) {
                    field.set(obj, context.deserialize(value, field.getType()));
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat(jdf.pattern());
                    sdf.setTimeZone(TimeZone.getTimeZone(jdf.timezone()));
                    field.set(obj, sdf.parse(value.getAsString()));
                }
            } catch (IllegalAccessException | IllegalArgumentException | ParseException e) {
                log.info(MessageUtil.getMsg("error.unexpected"));
                log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
                throw new JsonParseException(e.getMessage());
            }
        }
        return obj;
    }

}
