package Level2.디펜스게임;

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    private static PriorityQueue<Integer> resultQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;

        for(int index = 0; index < enemy.length; index++) {
            n -= enemy[index];
            resultQueue.offer(enemy[index]);

            while(n < 0) {
                if(k > 0 && !resultQueue.isEmpty()) {
                    k--;
                    n += resultQueue.poll();
                    continue;
                }

                return index;
            }
        }

        return enemy.length;
    }
}