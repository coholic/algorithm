package Level2.전력망을둘로나누기;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    private static List<List<Integer>> resultList;
    private static int minGap = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        initResultList(n);
        mkResultList(wires);

        for(int index = 1; index < resultList.size(); index++) {
            for(int linkedNumber : resultList.get(index)) {
                int length1 = getNodeCount(index, linkedNumber);
                int length2 = getNodeCount(linkedNumber, index);

                minGap = Math.min(minGap, Math.abs(length1 - length2));
            }
        }

        return (minGap == Integer.MAX_VALUE)? 0 : minGap;
    }

    private void initResultList(int length) {
        resultList = new ArrayList<>(length + 1);

        for(int index = 0; index <= length; index++) {
            resultList.add(new ArrayList<>());
        }
    }

    private static void mkResultList(int[][] wires) {
        for(int[] arr : wires) {
            int from = arr[0];
            int to = arr[1];

            resultList.get(from).add(to);
            resultList.get(to).add(from);
        }
    }

    private static int getNodeCount(int startNumber, int banned) {
        Queue<Integer> resultQueue = new LinkedList<>();
        boolean[] visitArr = new boolean[resultList.size()];

        int count = 0;

        visitArr[startNumber] = true;
        resultQueue.offer(startNumber);

        while(!resultQueue.isEmpty()) {
            int currentNumber = resultQueue.poll();
            count++;

            for(int nextNumber : resultList.get(currentNumber)) {
                if(visitArr[nextNumber]) continue;
                if(nextNumber == banned) continue;

                visitArr[nextNumber] = true;
                resultQueue.offer(nextNumber);
            }
        }

        return count;
    }
}