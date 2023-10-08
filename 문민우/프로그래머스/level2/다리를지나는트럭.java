package level2;

import java.util.Queue;
import java.util.LinkedList;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;

        for (int truck : truck_weights) {

            while (true) {

                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                }

                else if (queue.size() == bridge_length)
                    sum -= queue.poll();

                else {

                    if (sum + truck > weight) {
                        queue.offer(0);
                        answer++;
                    }

                    else {
                        queue.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
