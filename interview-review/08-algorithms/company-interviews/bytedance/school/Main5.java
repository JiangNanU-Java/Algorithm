package bytedance.school;

import java.util.HashMap;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) {
        String s1  = "a = 0 - b";
        String s2  = "b = 2 - c";
        String s3  = "c = 4 - d";

        String q1 = "b - d";
        String q2 = "b - c";

        String[] queryKeys = q1.split(" ");
        String key1 = queryKeys[0];
        String key = queryKeys[1];
        String key2 = queryKeys[2];

        Map<String,Integer> left = new HashMap<>();
        left.put("a",1);
        left.put("b",2);
        left.put("c",3);

        Map<String,Integer> right = new HashMap<>();
        right.put("b",1);
        right.put("c",2);
        right.put("d",3);

        int leftIndex = left.get(key1);
        int rightIndex = right.get(key2);

        System.out.println(leftIndex+" " +rightIndex);
    }
}
