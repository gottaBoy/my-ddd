package com.my.ddd.common.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GsonUtil {

    private static Gson gson = null;

    static {
        if (Objects.isNull(gson)) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
                        String datetime = json.getAsJsonPrimitive().getAsString();
                        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    })
                    .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                        String datetime = json.getAsJsonPrimitive().getAsString();
                        return LocalDate.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    })
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, type, jsonDeserializationContext) -> {
                        String datetime = json.getAsJsonPrimitive().getAsString();
                        LocalDateTime localDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                    })
                    .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) -> new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                    .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) -> new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                    .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (src, typeOfSrc, context) -> {
                        LocalDateTime localDateTime = LocalDateTime.ofInstant(src.toInstant(), ZoneId.systemDefault());
                        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    })
                    .create();
        }
    }

    public GsonUtil() {
    }

    /**
     * ???object????????????json?????????
     *
     * @param object
     * @return
     */
    public static String gsonToString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * ???gsonString????????????bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T gsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * ??????list
     * ?????????????????????????????????????????????
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, TypeToken.getParameterized(List.class,cls).getType());
        }
        return list;
    }

    /**
     * ??????list??????map???
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }


    /**
     * ??????map???
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * ?????????bean?????????????????????????????????????????????json
     * @param object
     * @return
     */
    public static String beanToJson(Object object){
        return gson.toJson(object);
    }
}
