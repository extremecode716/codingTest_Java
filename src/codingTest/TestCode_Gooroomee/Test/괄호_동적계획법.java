package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
// https://www.acmicpc.net/problem/10422
public class 괄호_동적계획법 {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;

		for (int i = 2; i <= 2500; ++i) {
			for (int j = 0; j <= i - 1; ++j) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i * 2] %= 1000000007L;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n] + "\n");
		}
		System.out.println(sb);

	}

}
