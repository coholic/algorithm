package level2.리코쳇로봇;

import java.util.*;

public class Solution {

    private static int row, col;
    private static char[][] map;
    private static boolean[][] visited;
    private static int startRow, startCol;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public int solution(String[] board) {

        row = board.length;
        col = board[0].length();
        map = new char[row][col];
        visited = new boolean[row][col];

        initMap(board);

        return bfs();
    }

    private void initMap(String[] board) {

        for (int i = 0; i < row; i++) {

            String str = board[i];

            for (int j = 0; j < col; j++) {

                if (str.charAt(j) == 'R') {

                    startRow = i;
                    startCol = j;
                }

                map[i][j] = str.charAt(j);
            }
        }
    }

    private int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            int nowCount = now[2];

            for (int i = 0; i < 4; i++) {

                int nextRow = nowRow;
                int nextCol = nowCol;

                while (true) {

                    nextRow += dr[i];
                    nextCol += dc[i];

                    if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col)
                        break;

                    if (map[nextRow][nextCol] == 'D') {

                        nextRow -= dr[i];
                        nextCol -= dc[i];

                        break;
                    }
                }

                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {

                    if (nextRow < 0)
                        nextRow = 0;

                    else if (nextRow >= row)
                        nextRow = row - 1;

                    else if (nextCol < 0)
                        nextCol = 0;

                    else
                        nextCol = col - 1;
                }

                if (map[nextRow][nextCol] == 'G')
                    return nowCount + 1;

                if (!visited[nextRow][nextCol]) {

                    queue.offer(new int[] {nextRow, nextCol, nowCount + 1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return -1;
    }
}