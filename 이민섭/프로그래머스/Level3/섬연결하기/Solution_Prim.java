package Level3.섬연결하기;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

// 프림 알고리즘을 활용하여 해결한 풀이
class Solution_Prim {
    public static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    public static List<ArrayList<Node>> resultList = new ArrayList<>();

    public int solution(int n, int[][] costs) {
        initPriorityQueue();
        initResultList(n);

        mkResultList(costs);

        return getMinValue();
    }

    public int getMinValue() {
        boolean[] visit = new boolean[resultList.size()];
        int minValue = 0;
        priorityQueue.offer(new Node(0, 0));

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            int number = node.getNumber();
            int weight = node.getWeight();

            if(visit[number]) continue;

            visit[number] = true;
            minValue += weight;

            for(Node n : resultList.get(number)) {
                if(!visit[n.getNumber()]) priorityQueue.offer(n);
            }
        }


        return minValue;
    }

    public void initPriorityQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    public void initResultList(int length) {
        for(int i = 0; i < length; i++) {
            resultList.add(new ArrayList<>());
        }
    }

    public void mkResultList(int[][] costs) {
        for(int[] arr : costs) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];

            resultList.get(from).add(new Node(to, cost));
            resultList.get(to).add(new Node(from, cost));
        }
    }

    public class Node implements Comparable<Node>{
        private int number;
        private int weight;

        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        public int getNumber() {
            return this.number;
        }

        public int getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Node o1) {
            return this.getWeight() - o1.getWeight();
        }
    }
}