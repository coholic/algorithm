package Level2.프로세스;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    private static Queue<Node> resultQueue = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        initPriorityQueue(priorities);
        initResultQueue(priorities);

        return getResultCount(priorities, location);
    }

    public int getResultCount(int[] arr, int index) {
        int maxValue = priorityQueue.poll(); // 배열 내부 최댓값
        int value = arr[index]; // 우리가 찾아야하는 값
        int resultCount = 1;

        while(true) {
            Node node = resultQueue.poll();

            int nodeValue = node.getValue();
            int nodeIndex = node.getIndex();

            if(nodeValue == value &&
                    nodeIndex == index &&
                    nodeValue == maxValue) break;
            if(nodeValue == maxValue) {
                resultCount++;
                maxValue = priorityQueue.poll();
                continue;
            }
            if(nodeValue < maxValue) {
                resultQueue.offer(node);
                continue;
            }
        }

        return resultCount;
    }

    public void initPriorityQueue(int[] values) {
        for(int value : values) {
            priorityQueue.offer(value);
        }
    }

    public void initResultQueue(int[] values) {
        for(int i = 0; i < values.length; i++) {
            resultQueue.offer(new Node(values[i], i));
        }
    }

    public class Node {
        private int value;
        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
