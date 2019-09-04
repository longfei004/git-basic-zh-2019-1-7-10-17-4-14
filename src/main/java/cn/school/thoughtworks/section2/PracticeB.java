package cn.school.thoughtworks.section2;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> map = new HashMap<>();
        for (String collection : collection1) {
            if (map.containsKey(collection))
                map.put(collection, map.get(collection) + 1);
            else if(collection.contains("-"))
                map.put(collection.split("-")[0], Integer.valueOf(collection.split("-")[1]));
            else
                map.put(collection, 1);
        }
        return map;
    }
}
