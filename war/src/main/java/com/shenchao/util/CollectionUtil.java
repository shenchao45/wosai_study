package com.shenchao.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionUtil {
    public static Map<String,Object> hashMap(Object... objects) {
        Map result = new LinkedHashMap();
        for(int i = 0;i<objects.length/2;i++) {
            result.put(objects[2 * i], objects[2 * i + 1]);
        }
        return result;
    }
}
