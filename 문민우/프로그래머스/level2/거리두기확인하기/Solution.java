package level2.거리두기확인하기;

public class Solution {

    private static final int LEN = 5;

    private char[][] map;
    private boolean[][] visited;
    private int result;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {

        int[] answer = new int[LEN];
        visited = new boolean[LEN][LEN];

        for (int i = 0; i < LEN; i++) {

            map = new char[LEN][LEN];
            result = 1;

            for (int j = 0; j < LEN; j++) {

                String str = places[i][j];

                for (int k = 0; k < LEN; k++) {

                    map[j][k] = str.charAt(k);
                }
            }

            for (int j = 0; j < LEN; j++) {

                for (int k = 0; k < LEN; k++) {

                    if (map[j][k] == 'P') {

                        if (result == 1) {

                            dfs(j, k, 0);
                        }
                    }
                }
            }

            answer[i] = result;
        }

        return answer;
    }

    private void dfs(int row, int col, int depth) {

        if (depth == 1 || depth == 2) {

            if (map[row][col] == 'P') {

                result = 0;
                return;
            }
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow < 0 || nextRow >= LEN || nextCol < 0 || nextCol >= LEN)
                continue;

            if (visited[nextRow][nextCol])
                continue;

            if (map[nextRow][nextCol] == 'X')
                continue;

            dfs(nextRow, nextCol, depth + 1);
        }

        visited[row][col] = false;
    }
}