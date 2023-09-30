package level2;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {

        int answer = 0;

        Stack<Integer> subContainer = new Stack<>();
        int index = 0;

        for (int i = 1; i <= order.length; i++) {

            if (order[index] != i)
                subContainer.push(i);

            else {
                index++;
                answer++;
            }

            while (!subContainer.isEmpty() && subContainer.peek() == order[index]) {

                subContainer.pop();

                index++;
                answer++;
            }
        }

        return answer;
    }
}