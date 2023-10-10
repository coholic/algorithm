package Level2.두큐합같게만들기;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> deque1 = getDeque(queue1);
        Deque<Integer> deque2 = getDeque(queue2);

        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);

        return getResult(deque1, deque2, sum1, sum2);
    }

    public int getResult(Deque<Integer> deque1, Deque<Integer> deque2,
                         long sum1, long sum2) {
        long total = sum1 + sum2;
        int length = deque1.size();
        int result = 0;

        while(total/2 != sum1) {
            if(result > length * 3) return -1;

            result++;

            if(sum1 < sum2) {
                int popValue = deque2.pop();
                deque1.addLast(popValue);
                sum1 += popValue;
                sum2 -= popValue;
                continue;
            }

            int popValue = deque1.pop();
            deque2.addLast(popValue);
            sum1 -= popValue;
            sum2 += popValue;
        }

        return result;
    }

    public Deque<Integer> getDeque(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();

        for(int value : arr) {
            deque.offer(value);
        }

        return deque;
    }

    public long getSum(int[] arr) {
        long sum = 0;

        for(int value : arr) {
            sum += value;
        }

        return sum;
    }
}