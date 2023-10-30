package level2;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class 프로세스 {
    public int solution(int[] priorities, int location) {

        int answer = 1;

        List<Integer> priorityList = new ArrayList<>();
        Queue<Integer> order = new LinkedList<>();

        int maxPriority = 1;

        for (int i = 0; i < priorities.length; i++) {

            priorityList.add(priorities[i]);
            order.offer(i);

            maxPriority = Math.max(priorities[i], maxPriority);
        }

        while (true) {

            int now = priorityList.get(0);

            if (now == maxPriority) {

                if (order.peek() == location)
                    break;

                else {

                    priorityList.remove(0);
                    order.poll();
                    answer++;

                    maxPriority = 1;

                    for (int priority : priorityList) {
                        maxPriority = Math.max(priority, maxPriority);
                    }
                }
            }

            else {

                priorityList.remove(0);
                priorityList.add(now);
                order.offer(order.poll());
            }
        }

        return answer;
    }
}
