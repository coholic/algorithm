import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int i : priorities){
            pQueue.offer(i);
        }
        while (!pQueue.isEmpty()){
            for (int i =0;i<priorities.length;i++){
                if (pQueue.peek() == priorities[i]){
                    pQueue.poll();
                    answer++;
                    if (location == i){
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}