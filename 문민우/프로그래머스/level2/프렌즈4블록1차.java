package level2;

import java.util.List;
import java.util.ArrayList;

public class 프렌즈4블록1차 {
    static char[][] map;  // board
    static boolean[][] checkMap;
    static int r, c;

    public int solution(int m, int n, String[] board) {

        int answer = 0;
        r = m;
        c = n;

        initializeBoard(board);

        while (true) {

            if (!checkBlock())  // 2 * 2 block 이 없을 경우
                break;

            answer += countAndReLocateBlock();
        }

        return answer;
    }

    public void initializeBoard(String[] board) {  //  String[] board to char[] map

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = board[i].toCharArray();
        }
    }

    public boolean checkBlock() {  // 2 * 2 block 이 있는지 체크

        boolean flag = false;
        checkMap = new boolean[r][c];

        for (int i = 0; i < r - 1; i++) {

            for (int j = 0; j < c - 1; j++) {

                char target = map[i][j];

                if (target != '0' && target == map[i + 1][j] && target == map[i][j + 1] &&
                        target == map[i + 1][j + 1]) {

                    checkMap[i][j] = true;
                    checkMap[i + 1][j] = true;
                    checkMap[i][j + 1] = true;
                    checkMap[i + 1][j + 1] = true;

                    flag = true;
                }
            }
        }

        return flag;
    }

    public int countAndReLocateBlock() {  // 제거된 블록의 개수를 카운트하고, 블록들을 재배치한다.

        int removedBlock = 0;

        for (int j = 0; j < c; j++) {

            List<Character> list = new ArrayList<>();  // 해당 열에 대해서 남아있는 블록

            for (int i = r - 1; i >= 0; i--) {  // 2 * 2 블록을 만족한다면 제거

                if (!checkMap[i][j])
                    list.add(map[i][j]);

                else
                    removedBlock++;
            }

            for (int i = r - 1, idx = 0; i >= 0; i--, idx++) {  // 남아 있는 블록 재배치

                if (idx < list.size())
                    map[i][j] = list.get(idx);

                else
                    map[i][j] = '0';  // 블록이 없을 경우
            }
        }

        return removedBlock;
    }
}
