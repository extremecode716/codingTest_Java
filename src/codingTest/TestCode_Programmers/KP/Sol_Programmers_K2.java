package codingTest.TestCode_Programmers.KP;

import java.util.Arrays;

// KP2
public class Sol_Programmers_K2 {

    public int[] solution(int rows, int columns, int[][] swipes) {
        int[][] table = new int[rows + 1][columns + 1];
        int num = 0;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= columns; ++j) {
                table[i][j] = ++num;
            }
        }

        // d:1 아래, d:2 위, d:3 우, d:4 좌
        for (int i = 0; i < swipes.length; ++i) {
            int d = swipes[i][0];
            int startY = swipes[i][1];
            int startX = swipes[i][2];
            int endY = swipes[i][3];
            int endX = swipes[i][4];
            int tmp;
            switch (d) {
                case 1://아래
                    for (int x = startX; x <= endX; ++x) {
                        tmp = table[endY][x];
                        for (int c = endY - 1; c >= startY; --c) {
                            table[c + 1][x] = table[c][x];
                        }
                        table[startY][x] = tmp;
                    }
                    break;
                case 2://위
                    for (int x = startX; x <= endX; ++x) {
                        tmp = table[startY][x];
                        for (int c = startY + 1; c <= endY; ++c) {
                            table[c - 1][x] = table[c][x];
                        }
                        table[endY][x] = tmp;
                    }
                    break;
                case 3://우
                    for (int y = startY; y <= endY; ++y) {
                        tmp = table[y][endX];
                        for (int c = endX - 1; c >= startX; --c) {
                            table[y][c + 1] = table[y][c];
                        }
                        table[y][startX] = tmp;
                    }
                    break;
                case 4://좌
                    for (int y = startY; y <= endY; ++y) {
                        tmp = table[y][startX];
                        for (int c = startX + 1; c <= endX; ++c) {
                            table[y][c - 1] = table[y][c];
                        }
                        table[y][endX] = tmp;
                    }
                    break;
            }
        }

        int[] result = new int[rows];
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= columns; ++j) {
                result[i - 1] += table[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sol_Programmers_K2 sol = new Sol_Programmers_K2();
        System.out.println(Arrays.toString(sol.solution(4, 3, new int[][]{{1, 1, 2, 4, 3}, {3, 2, 1, 2, 3}, {4, 1, 1, 4, 3}, {2, 2, 1, 3, 3}})));
    }
}
