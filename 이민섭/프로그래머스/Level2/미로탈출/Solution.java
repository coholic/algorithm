package Level2.미로탈출;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    private static char[][] resultArr;
    private static boolean[][] visitArr;
    private static int[][] weightArr;
    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    private final static char START_POINT = 'S';
    private final static char END_POINT = 'E';
    private final static char WALL_POINT = 'X';
    private final static char LEVER_POINT = 'L';
    private static int leverCount = 0;
    private static int endCount = 0;

    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();

        initResultArr(N, M);
        initVisitArr();
        initWeightArr();

        mkResultArr(maps);

        boolean flag = false;

        for(int height = 0; height < resultArr.length; height++) {
            for(int width = 0; width < resultArr[0].length; width++) {
                if(resultArr[height][width] != START_POINT) continue;

                leverCount = findPath(height, width, LEVER_POINT);

                if(leverCount == 0) break;
                flag = true;
            }
        }

        if(!flag) return -1;

        initVisitArr();
        initWeightArr();

        flag = false;

        for(int height = 0; height < resultArr.length; height++) {
            for(int width = 0; width < resultArr[0].length; width++) {
                if(resultArr[height][width] != LEVER_POINT) continue;

                endCount = findPath(height, width, END_POINT);

                if(endCount == 0) break;
                flag = true;
            }
        }

        if(!flag) return -1;

        return leverCount + endCount;
    }

    private static void initResultArr(int height, int width) {
        resultArr = new char[height][width];
    }

    private static void initVisitArr() {
        visitArr = new boolean[resultArr.length][resultArr[0].length];
    }

    private static void initWeightArr() {
        weightArr = new int[resultArr.length][resultArr[0].length];

        for(int height = 0; height < resultArr.length; height++) {
            Arrays.fill(weightArr[height], Integer.MAX_VALUE);
        }
    }

    private static void mkResultArr(String[] arr) {
        for(int height = 0; height < arr.length; height++) {
            resultArr[height] = arr[height].toCharArray();
        }
    }

    private static int findPath(int height, int width, char target) {
        Queue<int[]> resultQueue = new LinkedList<>();
        visitArr[height][width] = true;
        weightArr[height][width] = 0;
        resultQueue.offer(new int[]{height, width});

        while(!resultQueue.isEmpty()) {
            int[] arr = resultQueue.poll();

            int y = arr[0];
            int x = arr[1];

            if(resultArr[y][x] == target) return weightArr[y][x];

            int weight = weightArr[y][x];

            for(int i = 0; i < 4; i++) {
                int xValue = x + dx[i];
                int yValue = y + dy[i];

                if(xValue < 0 || yValue < 0 || xValue >= resultArr[0].length || yValue >= resultArr.length) continue;
                if(visitArr[yValue][xValue]) continue;
                if(weightArr[yValue][xValue] < weight + 1) continue;
                if(resultArr[yValue][xValue] == WALL_POINT) continue;

                visitArr[yValue][xValue] = true;
                weightArr[yValue][xValue] = weight + 1;

                resultQueue.offer(new int[]{yValue, xValue});
            }
        }

        return 0;
    }
}