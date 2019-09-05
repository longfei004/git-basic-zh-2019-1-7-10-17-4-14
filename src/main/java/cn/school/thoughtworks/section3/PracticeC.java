package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        HashMap<String, Integer> collection3 = new HashMap<>();
        collectionA.forEach(str -> collection3.put(str, collection3.containsKey(str) ? collection3.get(str) + 1 : 1));
        return collection3.entrySet().stream().peek(it -> it.setValue(object.get("value").contains(it.getKey()) ? it.getValue() - it.getValue()/3 : it.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}
