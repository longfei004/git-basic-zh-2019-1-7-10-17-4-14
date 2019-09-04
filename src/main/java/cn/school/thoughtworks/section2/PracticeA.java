package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        HashMap<String, Integer> hashMap = new HashMap<>();
        collection1.forEach(str -> hashMap.put(str, hashMap.containsKey(str) ? hashMap.get(str) + 1 : 1));
        return hashMap;
    }
}
