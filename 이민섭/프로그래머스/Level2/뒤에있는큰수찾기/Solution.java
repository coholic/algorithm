package Level2.뒤에있는큰수찾기;

import java.util.Stack;

class Solution {
    private static Stack<Integer> resultStack = new Stack<>();

    public int[] solution(int[] numbers) {
        int[] resultArr = new int[numbers.length];

        resultStack.push(0);

        for(int i = 1; i < resultArr.length; i++) {
            while(!resultStack.isEmpty() && numbers[resultStack.peek()] < numbers[i]) {
                int index = resultStack.pop();

                resultArr[index] = numbers[i];
            }

            resultStack.push(i);
        }

        convertZero(resultArr);

        return resultArr;
    }

    private void convertZero(int[] resultArr) {
        for(int i = 0; i < resultArr.length; i++) {
            if(resultArr[i] == 0) {
                resultArr[i] = -1;
            }
        }
    }
}