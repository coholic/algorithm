package Level2.압축;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class Solution {
    private static Map<String, Integer> resultMap = new HashMap<>();
    private static List<Integer> resultList = new LinkedList<>();
    private static int lastIndex = 26;

    public int[] solution(String msg) {
        initMap();

        while(msg.length() != 0) {
            String w = getLongestW(msg);
            String c = getC(w, msg);

            int index = resultMap.get(w);

            resultList.add(index);
            resultMap.put(w + c, ++lastIndex);

            msg = msg.substring(w.length());
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void initMap() {
        for(int i = 0; i < lastIndex; i++) {
            resultMap.put(String.valueOf((char)('A' + i)), i+1);
        }
    }

    private String getLongestW(String value) {
        String W = "";

        for(char word : value.toCharArray()) {
            if(!resultMap.containsKey(W + word)) return W;
            W += word;
        }

        return W;
    }

    private String getC(String key, String value) {
        int index = value.indexOf(key);

        if(index + key.length() + 1 >= value.length()) {
            return "";
        }

        return value.substring(index + key.length(), index + key.length() + 1);
    }
}
