package level2.롤케이크자르기;

import java.util.*;

public class Solution {
    public int solution(int[] topping) {

        int answer = 0;

        Set<Integer> chulsu = new HashSet<>();
        Map<Integer, Integer> brother = new HashMap<>();

        chulsu.add(topping[0]);

        for (int i = 1; i < topping.length; i++) {
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1; i < topping.length; i++) {

            if (chulsu.size() == brother.size())
                answer++;

            chulsu.add(topping[i]);
            brother.put(topping[i], brother.get(topping[i]) - 1);

            if (brother.get(topping[i]) == 0)
                brother.remove(topping[i]);
        }

        return answer;
    }
}