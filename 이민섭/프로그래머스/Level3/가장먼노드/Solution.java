package Level3.가장먼노드;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Solution {
    private static Node[] resultArr;
    private static boolean[] visitArr;
    private static int maxWeight = Integer.MIN_VALUE;

    public int solution(int n, int[][] edge) {
        initResultArr(n);
        initVisitArr(n);

        mkResultArr(edge);

        bfs();

        return getMaxCount();
    }

    private static void initResultArr(int length) {
        resultArr = new Node[length+1];

        for(int i = 1; i < resultArr.length; i++) {
            resultArr[i] = new Node(i);
        }

        resultArr[1].setWeight(0);
    }

    private static void initVisitArr(int length) {
        visitArr = new boolean[length+1];
    }

    private static void mkResultArr(int[][] edge) {
        for(int[] arr : edge) {
            int from = arr[0];
            int to = arr[1];

            resultArr[from].getLink().add(to);
            resultArr[to].getLink().add(from);
        }
    }

    private static void bfs() {
        Queue<Node> resultQueue = new LinkedList<>();
        resultQueue.offer(resultArr[1]);
        visitArr[1] = true;

        while(!resultQueue.isEmpty()) {
            Node node = resultQueue.poll();

            int weight = node.getWeight();

            maxWeight = Math.max(weight, maxWeight);

            for(int nextIndex : node.getLink()) {
                if(visitArr[nextIndex]) continue;
                Node nextNode = resultArr[nextIndex];

                visitArr[nextIndex] = true;
                nextNode.setWeight(weight+1);
                resultQueue.offer(nextNode);
            }
        }
    }

    private static int getMaxCount() {
        int count = 0;

        for(int i = 1; i < resultArr.length; i++) {
            Node node = resultArr[i];

            if(node.getWeight() == maxWeight) count++;
        }

        return count;
    }

    private static class Node {
        private int number;
        private int weight;
        private List<Integer> link = new LinkedList<>();

        public Node(int number) {
            this.number = number;
            this.weight = Integer.MAX_VALUE;
        }

        public int getNumber() {
            return this.number;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public List<Integer> getLink() {
            return this.link;
        }
    }
}