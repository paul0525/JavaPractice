package practice.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class TestMap {

    public static void main(String[] args) {

        Map<String, List> map = new HashMap<>();

        map.computeIfAbsent("key",key->new ArrayList(){{add("aaa");}});
        map.computeIfAbsent("key",key->new ArrayList(){{add("bbb");}});

        System.out.println(map);

    }
}
