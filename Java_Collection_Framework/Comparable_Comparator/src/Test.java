import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        String chuoi = "abcdaa";
        for (int i = 0; i < chuoi.length(); i++) {
            String key = chuoi.charAt(i) + "";
            if (stringIntegerMap.containsKey(key)) {
                int count = stringIntegerMap.get(key);
                count++;
                stringIntegerMap.put(key, count);
            } else {
                stringIntegerMap.put(key, 1);
            }
        }
        Set<String> keys = stringIntegerMap.keySet();
        for (String key : keys) {
            System.out.println(key + ":" + stringIntegerMap.get(key));

        }


    }


}
