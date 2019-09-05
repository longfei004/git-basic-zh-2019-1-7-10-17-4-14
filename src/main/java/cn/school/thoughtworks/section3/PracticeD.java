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
        AtomicReference<String> str = new AtomicReference<>("");
        collection1.forEach(it -> {
            String regex = "^([a-zA-Z]+)\\W([0-9]+).*";
            if(!Pattern.matches(regex, it)) {
                map.put(it, map.containsKey(it) ? map.get(it) + 1 : 1);
            } else {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(it);
                if (matcher.find()) {
                    String key = matcher.group(1);
                    String count = matcher.group(2);
                    map.put(key, map.containsKey(key) ? map.get(key) + Integer.parseInt(count) : Integer.parseInt(count));
                }
            }
        });
        return map;
    }
}
