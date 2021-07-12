package codingTest.TestCode_BackJoon.DP.p1463;

import java.io.*;
// DP
// 1.Top-Down(재귀함수): 작은 부분의 답을 저장해 이미 계산을 진행한 작은문제는 저장된 값을 이용한다.
// 2.Bottm-Up(반복문): 제일 작은 문제부터 차례대로 풀면서 정답을 구해나가는 방법.
// https://www.acmicpc.net/problem/1463
public class Main {
    static Integer[] dp;

    static void bottomUp(int x) {
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= x; ++i) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
    }

    static int topDown(int x) {
        if (x == 1) {
            return 0;
        }
        if (dp[x] != null) {
            return dp[x];
        }

        dp[x] = topDown(x - 1) + 1;
        if (x % 3 == 0) {
            dp[x] = Math.min(dp[x], topDown(x / 3) + 1);
        }
        if (x % 2 == 0) {
            dp[x] = Math.min(dp[x], topDown(x / 2) + 1);
        }

        return dp[x];
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputStr = br.readLine();
            int X = Integer.parseInt(inputStr);
            dp = new Integer[X + 1];
            bottomUp(X);
            System.out.println(dp[X]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
