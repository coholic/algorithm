package Level1;

import java.util.Set;
import java.util.TreeSet;

class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {

        Set<Integer> result = new TreeSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}