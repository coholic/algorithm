package level2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);  // 오름차순 정렬

        int left = 0;  // 가벼운 쪽
        int right = people.length - 1;  // 무거운 쪽

        while(left <= right) {

            if(people[left] + people[right] <= limit)  // 하나의 보트에 2명
                left++;

            // 하나의 보트에 right 1명
            right--;
            answer++;
        }

        return answer;
    }
}
