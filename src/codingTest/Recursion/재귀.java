package codingTest.Recursion;

import java.util.*;

// 재귀 함수
// 자기 자신을 호출하는 함수
// Base case
// 간단히 결과를 반환하는 부분
// Recursive case
// 자기 자신을 호출하는 부분

public class 재귀 {
	// Factorial
	// 수학적 정의
	// n = 0일 경우, n! = 1
	// n > 0일 경우, n! = n x (n - 1);
	int factorial(int n) {
		if (n == 0) // base case
			return 1;

		return n * factorial(n - 1); // recursive case
	}

	// Flood fill 알고리즘
	static class Floodfill {
		static int N;
		static int[][] Board = new int[100][100];

		static void fill(int r, int c) {
			if (r < 0 || r > N - 1 || c < 0 || c > N - 1) // 경계 벗어난 경우 base case
				return;

			if (Board[r][c] != 0)
				return; // 벽을 만났거나 혹은 1로 마킹된 경우 base case

			Board[r][c] = 1;

			// recursive case
			fill(r - 1, c); // 위
			fill(r + 1, c); // 아래
			fill(r, c - 1); // 좌
			fill(r, c + 1); // 우
		}
		public static void main() {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					Board[i][j] = sc.nextInt();
				}
			}
			int sRow, sCol;
			sRow = sc.nextInt();
			sCol = sc.nextInt();
			fill(sRow, sCol);
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					System.out.println(Board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
