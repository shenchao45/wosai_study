package com.shenchao.common.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shenchao on 17/12/13.
 */
public class MapUtil {
    /**
     * 如果value不为null，将value put进map（注意map不能为null）.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfNotNull(Map map, String key, Object value) {
        if (map != null && value != null) {
            map.put(key, value);
        }
    }

    /**
     * 如果value不为空，将value put进map（注意map不能为null）.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfNotEmpty(Map map, String key, String value) {
        if (map != null && !StringUtils.isEmpty(value)) {
            map.put(key, value);
        }
    }

    public static void removeNullValues(Object value) {
        if (value instanceof Map) {
            Map<String, Object> m = (Map<String, Object>) value;
            List<String> nullKeys = new ArrayList<String>();
            for (String key : m.keySet()) {
                Object v = m.get(key);
                if (v == null) {
                    nullKeys.add(key);
                } else if (v instanceof Map) {
                    removeNullValues(v);
                }
            }
            for (String key : nullKeys) {
                m.remove(key);
            }
        }
    }

    public static void removeNullValuesAndConvertValueToString(Object value) {
        if (value instanceof Map) {
            Map<String, Object> m = (Map<String, Object>) value;
            List<String> nullKeys = new ArrayList<String>();
            for (String key : m.keySet()) {
                Object v = m.get(key);
                if (v == null) {
                    nullKeys.add(key);
                } else if (v instanceof Map) {
                    removeNullValuesAndConvertValueToString(v);
                } else if (!(v instanceof String)) {
                    m.put(key, v.toString());
                }
            }
            for (String key : nullKeys) {
                m.remove(key);
            }
        }
    }

    public static void removeKeys(Map<String, Object> map, String[] keysNotAllowed) {
        if (map == null || map.size() == 0 || keysNotAllowed == null || keysNotAllowed.length == 0) {
            return;
        }
        for (String key : keysNotAllowed) {
            map.remove(key);
        }
    }

    public static Object getPropValue(Map map, String key) {
        if (map == null) {
            return null;
        } else {
            return map.get(key);
        }
    }
}
