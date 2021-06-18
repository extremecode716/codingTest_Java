package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
//https://level.goorm.io/exam/88520/%EB%86%80%EC%9D%B4%EA%B3%B5%EC%9B%90/quiz/1
public class 놀이공원_lv3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		int T = Integer.parseInt(input1);
		for (int v = 0; v < T; ++v) {
			String[] input2 = br.readLine().split(" ");

			int N = Integer.parseInt(input2[0]);
			int C = Integer.parseInt(input2[1]);
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; ++i) {
				String[] cols = br.readLine().split(" ");
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(cols[j]);
				}
			}

			int min = C * C;
			int cnt = C * C;
			for (int a = 0; a < N - C + 1; ++a) {
				for (int b = 0; b < N - C + 1; ++b) {
					cnt = C * C;
					for (int i = a; i < a + C; ++i) {
						for (int j = b; j < b + C; ++j) {
							if (arr[i][j] == 0) {
								--cnt;
							}
						}
					}
					min = Math.min(min, cnt);
				}
			}

			System.out.println(min);

			
		}
		br.close();
	}
	
}
