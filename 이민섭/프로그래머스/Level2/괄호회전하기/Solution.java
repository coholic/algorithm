package Level2.괄호회전하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int count = 0;

        for(int i = 0; i < length; i++) {
            String value = makeString(s, i);
            if(checkValidation(value)) count++;
        }

        return count;
    }

    public String makeString(String value, int cycle) {
        if(cycle == 0) return value;
        return value.substring(cycle) + value.substring(0, cycle);
    }

    public boolean checkValidation(String word) {
        Stack<Character> resultStack = new Stack<>();

        for(char value : word.toCharArray()) {
            if(value == '(' || value == '[' || value == '{') {
                resultStack.push(value);
                continue;
            }

            if(resultStack.isEmpty()) return false;

            char peekValue = resultStack.peek();

            if((peekValue == '(' && value != ')') ||
                    (peekValue == '{' && value != '}') ||
                    (peekValue == '[' && value != ']')) return false;

            resultStack.pop();
        }

        return resultStack.isEmpty();
    }
}