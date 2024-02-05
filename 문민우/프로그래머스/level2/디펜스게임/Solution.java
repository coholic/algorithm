package level2.디펜스게임;

import java.util.*;

public class Solution {
    public int solution(int n, int k, int[] enemy) {

        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {

            n -= enemy[i];
            priorityQueue.offer(enemy[i]);

            if (n < 0) {

                if (k > 0) {

                    n += priorityQueue.poll();
                    k--;
                }

                else {

                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}