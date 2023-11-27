package level2.뒤에있는큰수찾기;

import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}