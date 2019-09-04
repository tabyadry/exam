package problem1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("Smith", "949–0504");
        map1.put("Marty", "206–9024");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("Smith", "949–0504");
        map2.put("Hawking", "123–4567");
        map2.put("Marty", "206–9024");
        map2.put("Newton", "123–4567");

        Main main = new Main();
        System.out.println(main.isSubMap(map1, map2));

    }

    private boolean isSubMap(Map<String, String> map1, Map<String, String> map2) {
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map2.get(key).equalsIgnoreCase(map1.get(key)) == false) {
                return false;
            }
        }
        return true;
    }
}
