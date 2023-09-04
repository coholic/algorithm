package Level2.방문길이;

class Solution {
    public static Node[][] resultArr = new Node[11][11];
    public static int length = 0;

    public int solution(String dirs) {
        initResultArr();
        getVisitLength(dirs);

        return length;
    }

    public void getVisitLength(String directions) {
        String[] directionArr = directions.split("");
        Node node = resultArr[5][5];

        for(String direction : directionArr) {
            node = processCommand(node, direction);
        }
    }

    public Node processCommand(Node node, String command) {
        if(command.equals("U")) node = moveUp(node);
        if(command.equals("D")) node = moveDown(node);
        if(command.equals("R")) node = moveRight(node);
        if(command.equals("L")) node = moveLeft(node);

        return node;
    }

    public Node moveUp(Node node) {
        int x = node.getX();
        int y = node.getY();

        if(y == 5) return node;

        Node nextNode = resultArr[y+6][x+5];

        if(!nextNode.isDown() && !node.isUp()) length++;
        nextNode.visitDown();
        node.visitUp();

        return nextNode;
    }

    public Node moveDown(Node node) {
        int x = node.getX();
        int y = node.getY();

        if(y == -5) return node;

        Node nextNode = resultArr[y+4][x+5];

        if(!nextNode.isUp() && !node.isDown()) length++;
        nextNode.visitUp();
        node.visitDown();

        return nextNode;
    }

    public Node moveRight(Node node) {
        int x = node.getX();
        int y = node.getY();

        if(x == 5) return node;

        Node nextNode = resultArr[y+5][x+6];

        if(!nextNode.isLeft() && !node.isRight()) length++;
        nextNode.visitLeft();
        node.visitRight();

        return nextNode;
    }

    public Node moveLeft(Node node) {
        int x = node.getX();
        int y = node.getY();

        if(x == -5) return node;

        Node nextNode = resultArr[y+5][x+4];
        if(!nextNode.isRight() && !node.isLeft()) length++;
        nextNode.visitRight();
        node.visitLeft();

        return nextNode;
    }

    public void initResultArr() {
        for(int i = 0; i < resultArr.length; i++) {
            for(int j = 0; j < resultArr[i].length; j++) {
                resultArr[i][j] = new Node(j-5, i-5);
            }
        }
    }

    public class Node {
        private int x;
        private int y;
        private boolean up;
        private boolean down;
        private boolean left;
        private boolean right;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.up = false;
            this.down = false;
            this.left = false;
            this.right = false;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public boolean isUp() {
            return this.up;
        }

        public boolean isDown() {
            return this.down;
        }

        public boolean isRight() {
            return this.right;
        }

        public boolean isLeft() {
            return this.left;
        }

        public void visitUp() {
            this.up = true;
        }

        public void visitDown() {
            this.down = true;
        }

        public void visitRight() {
            this.right = true;
        }

        public void visitLeft() {
            this.left = true;
        }
    }
}
