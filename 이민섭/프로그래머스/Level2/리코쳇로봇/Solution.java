package Level2.리코쳇로봇;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static Node[][] resultArr;
    private static int result;
    private static boolean flag = false;

    public int solution(String[] board) {
        initResultArr(board.length, board[0].length());

        for(int i = 0; i < board.length; i++) {
            mkResultArr(board[i].split(""), i);
        }

        for(int i = 0; i < resultArr.length; i++) {
            for(int j = 0; j < resultArr[0].length; j++) {
                if(!resultArr[i][j].getValue().equals("R")) continue;
                bfs(resultArr[i][j]);
            }
        }

        return getResult();
    }

    private static void initResultArr(int height, int width) {
        resultArr = new Node[height][width];
    }

    private static void mkResultArr(String[] infoArr, int height) {
        for(int i = 0; i < infoArr.length; i++) {
            resultArr[height][i] = new Node(i, height, infoArr[i]);
        }
    }

    private static void bfs(Node startNode) {
        Queue<Node> resultQueue = new LinkedList<>();
        startNode.visitNode();
        startNode.setDepth(0);
        resultQueue.offer(startNode);

        while(!resultQueue.isEmpty()) {
            Node node = resultQueue.poll();

            int x = node.getX();
            int y = node.getY();
            int depth = node.getDepth();
            String value = node.getValue();

            if(value.equals("G")) {
                flag = true;
                result = depth;
                break;
            }

            Node rightNode = getRightNode(x, y);
            Node leftNode = getLeftNode(x, y);
            Node upperNode = getUpperNode(x, y);
            Node lowerNode = getLowerNode(x, y);

            if(rightNode.getX() != -1 && rightNode.getY() != -1 &&
                    !rightNode.isVisit() && rightNode.getDepth() > depth + 1) {
                rightNode.visitNode();
                rightNode.setDepth(depth+1);
                resultQueue.offer(rightNode);
            }

            if(leftNode.getX() != -1 && leftNode.getY() != -1 &&
                    !leftNode.isVisit() && leftNode.getDepth() > depth + 1) {
                leftNode.visitNode();
                leftNode.setDepth(depth + 1);
                resultQueue.offer(leftNode);
            }

            if(upperNode.getX() != -1 && upperNode.getY() != -1 &&
                    !upperNode.isVisit() && upperNode.getDepth() > depth + 1) {
                upperNode.visitNode();
                upperNode.setDepth(depth + 1);
                resultQueue.offer(upperNode);
            }

            if(lowerNode.getX() != -1 && lowerNode.getY() != -1 &&
                    !lowerNode.isVisit() && lowerNode.getDepth() > depth + 1) {
                lowerNode.visitNode();
                lowerNode.setDepth(depth + 1);
                resultQueue.offer(lowerNode);
            }
        }
    }

    private static int getResult() {
        if(!flag) return -1;
        return result;
    }

    private static Node getRightNode(int x, int y) {
        for(int i = x; i <= resultArr[0].length-1; i++) {
            if(i == resultArr[0].length - 1) return resultArr[y][i];
            if(resultArr[y][i+1].getValue().equals("D")) return resultArr[y][i];
        }

        return new Node(-1, -1, "NULL");
    }

    private static Node getLeftNode(int x, int y) {
        for(int i = x; i >= 0; i--) {
            if(i == 0) return resultArr[y][i];
            if(resultArr[y][i-1].getValue().equals("D")) return resultArr[y][i];
        }

        return new Node(-1, -1, "NULL");
    }

    private static Node getUpperNode(int x, int y) {
        for(int i = y; i <= resultArr.length-1; i++) {
            if(i == resultArr.length-1) return resultArr[i][x];
            if(resultArr[i+1][x].getValue().equals("D")) return resultArr[i][x];
        }

        return new Node(-1, -1, "NULL");
    }

    private static Node getLowerNode(int x, int y) {
        for(int i = y; i >= 0; i--) {
            if(i == 0) return resultArr[i][x];
            if(resultArr[i-1][x].getValue().equals("D")) return resultArr[i][x];
        }

        return new Node(-1, -1, "NULL");
    }

    private static class Node {
        private int x;
        private int y;
        private int depth;
        private boolean visit;
        private String value;

        public Node(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.depth = Integer.MAX_VALUE;
            this.value = value;
            this.visit = false;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDepth() {
            return this.depth;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isVisit() {
            return this.visit;
        }

        public void visitNode() {
            this.visit = true;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }
}