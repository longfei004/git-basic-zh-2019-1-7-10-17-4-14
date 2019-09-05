package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> collection3 = countSameElements(collectionA);
        return collection3.entrySet().stream().peek(it -> it.setValue(object.get("value").contains(it.getKey()) ? it.getValue() - it.getValue()/3 : it.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> map = new HashMap<>();
        collection1.forEach(it -> {
            String strKey = "", strValue = "";
            for (int i = 0; i < it.length(); i++) {
                char charTemp = it.charAt(i);
                if(charTemp >= 'a' && charTemp <= 'z')
                    strKey += charTemp;
                else if (charTemp >= '0' && charTemp <= '9')
                    strValue += charTemp;
            }
            int value = strValue.equals("") ? 1 : Integer.parseInt(strValue);
            if (map.containsKey(strKey))
                map.put(strKey, map.get(strKey) + value);
            else
                map.put(strKey, value);
        });
        return map;
    }
}
