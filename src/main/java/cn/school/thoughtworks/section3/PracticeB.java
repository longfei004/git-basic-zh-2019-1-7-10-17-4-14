package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        return collectionA.entrySet().stream().peek(item -> item.setValue(object.get("value").contains(item.getKey()) ? item.getValue() - item.getValue()/3 : item.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
}
