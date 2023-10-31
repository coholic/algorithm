package Level2.뉴스클러스터링;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

class Solution {
    private final String PATTERN = "^[A-Z]*$";

    public int solution(String str1, String str2) {
        str1 = trimInput(str1);
        str2 = trimInput(str2);

        List<String> firstList = convertToList(str1);
        List<String> secondList = convertToList(str2);

        int intersectionCount = getIntersectionCount(firstList, secondList);
        int unionCount = getUnionCount(firstList, secondList, intersectionCount);

        return (int)getResult(intersectionCount, unionCount);
    }

    public String trimInput(String value) {
        return value.toUpperCase();
    }

    public List<String> convertToList(String value) {
        List<String> resultList = new LinkedList<>();

        for(int i = 0; i <= value.length()-2; i++) {
            String element = value.substring(i, i+2);

            if(!Pattern.matches(PATTERN, element)) continue;
            resultList.add(element);
        }

        return resultList;
    }

    public int getIntersectionCount(List<String> list1, List<String> list2) {
        Map<String, Integer> map1 = toMap(list1);
        Map<String, Integer> map2 = toMap(list2);

        int count = 0;

        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if(map2.containsKey(key)) count += Math.min(value, map2.get(key));
        }

        return count;
    }

    public Map<String, Integer> toMap(List<String> resultList) {
        Map<String, Integer> resultMap = new HashMap<>();

        for(String value : resultList) {
            resultMap.put(value, resultMap.getOrDefault(value, 0) + 1);
        }

        return resultMap;
    }

    public int getUnionCount(List<String> list1, List<String> list2, int count) {
        return list1.size() + list2.size() - count;
    }

    public double getResult(int interCount, int unionCount) {
        if(unionCount == 0) return 65536;
        return ((double)interCount / (double)unionCount) * (double)65536;
    }
}
