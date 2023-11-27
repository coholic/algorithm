package level2.압축;

import java.util.*;

public class Solution {
    static int index = 1;
    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        initMap();

        List<Integer> result = getResult(msg);
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    static void initMap() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(Character.toString(ch), index++);
        }
    }

    static List<Integer> getResult(String str) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            String w = "";

            while (i < str.length()) {
                if (!map.containsKey(w + str.charAt(i)))
                    break;
                else
                    w += str.charAt(i);

                i++;
            }

            result.add(map.get(w));

            if (i < str.length())
                map.put(w + str.charAt(i), index++);
        }

        return result;
    }
}