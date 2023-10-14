package level2;

import java.util.Queue;
import java.util.LinkedList;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {

        int answer = 0;

        long total = 0;
        long q1Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {

            total += (queue1[i] + queue2[i]);
            q1Sum += queue1[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if (total % 2 != 0)
            return -1;

        long target = total / 2;

        while (true) {

            if (answer > (queue1.length + queue2.length) * 2)
                return -1;

            if (q1Sum == target)
                break;

            else if (q1Sum > target) {
                q1Sum -= q1.peek();
                q2.offer(q1.poll());
            }

            else {
                q1Sum += q2.peek();
                q1.offer(q2.poll());
            }

            answer++;
        }

        return answer;
    }
}
