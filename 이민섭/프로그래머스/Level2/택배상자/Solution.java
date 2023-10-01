package Level2.택배상자;

import java.util.Stack;

class Solution {
    public static Stack<Integer> resultStack = new Stack<>();

    public int solution(int[] order) {
        return getResultCount(order);
    }

    public int getResultCount(int[] order) {
        int count = 0, current = 1;

        for(int i = 0; i < order.length; i++) {
            int value = order[i];

            if(value >= current) {
                for(int j = current; j <= value; j++) {
                    resultStack.push(j);
                }
                current = value + 1;
            }

            if(checkValidation(value)) {
                resultStack.pop();
                count++;
                continue;
            }

            break;
        }

        return count;
    }

    public boolean checkValidation(int value) {
        if(resultStack.isEmpty()) return false;
        int peekValue = resultStack.peek();
        return peekValue == value;
    }
}