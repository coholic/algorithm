package Level3.네트워크;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public static Node[] resultArr;

    public int solution(int n, int[][] computers) {
        initResultArr(n);
        mkResultArr(computers);

        return getResult();
    }

    public int getResult() {
        int count = 0;

        for(int i = 0; i < resultArr.length; i++) {
            Node node = resultArr[i];

            if(node.isVisit()) continue;
            dfs(node);
            count++;
        }

        return count;
    }

    public void dfs(Node node) {
        Queue<Node> resultQueue = new LinkedList<>();
        resultQueue.offer(node);

        while(!resultQueue.isEmpty()) {
            Node value = resultQueue.poll();

            if(value.isVisit()) continue;

            value.visitNode();

            for(int index : value.getLink()) {
                resultQueue.offer(resultArr[index-1]);
            }
        }
    }

    public void mkResultArr(int[][] computers) {
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[0].length; j++) {
                if(computers[i][j] == 0) continue;
                if(i == j) continue;

                int to = j+1;

                resultArr[i].getLink().add(to);
            }
        }
    }

    public void initResultArr(int length) {
        resultArr = new Node[length];

        for(int i = 0; i < length; i++) {
            resultArr[i] = new Node(i+1);
        }
    }

    public static class Node {
        private int number;
        private boolean visit;
        private List<Integer> link = new LinkedList<>();

        public Node(int number) {
            this.number = number;
            this.visit = false;
        }

        public int getNumber() {
            return this.number;
        }

        public boolean isVisit() {
            return this.visit;
        }

        public List<Integer> getLink() {
            return this.link;
        }

        public void visitNode() {
            this.visit = true;
        }
    }
}