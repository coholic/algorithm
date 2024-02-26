package level2.미로탈출;

import java.util.*;

public class Solution {
    private int row, col;
    private char[][] map;
    private boolean[][] visited;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length();
        map = new char[row][col];
        int[][] pos = new int[2][2];
        for (int i = 0; i < row; i++) {
            String str = maps[i];
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    pos[0][0] = i;
                    pos[0][1] = j;
                }
                if (map[i][j] == 'L') {
                    pos[1][0] = i;
                    pos[1][1] = j;
                }
            }
        }
        int d1 = bfs(pos[0][0], pos[0][1], 'L');
        int d2 = bfs(pos[1][0], pos[1][1], 'E');
        if (d1 == -1 || d2 == -1)
            return -1;
        return d1 + d2;
    }

    private int bfs(int sr, int sc, char target) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[row][col];
        queue.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (map[now[0]][now[1]] == target) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == 'X')
                    continue;
                queue.offer(new int[] {nr, nc, now[2] + 1});
                visited[nr][nc] = true;
            }
        }
        return -1;
    }
}