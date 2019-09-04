package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
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
                if (matcher.find())
                   map.put(matcher.group(1), map.containsKey(matcher.group(1)) ? map.get(matcher.group(1)) + Integer.parseInt(matcher.group(2)) : Integer.parseInt(matcher.group(2)));
            }
        });
        return map;
    }
}
