package Level1.두개뽑아서더하기;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public static Set<Integer> resultSet = new HashSet<>();

    public int[] solution(int[] numbers) {
        mkResultList(numbers);

        int[] resultArr = resultSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(resultArr);

        return resultArr;
    }

    public void mkResultList(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int value = numbers[i] + numbers[j];
                resultSet.add(value);
            }
        }
    }
}