package codingTest.DFS;
// 플루드 필은 도착점 까지 갈 수 있는지 판별 할 때도 사용한다.

import java.io.*;
import java.util.*;
public class DFS_Floodfill {
	static final int MAX_N = 10;
	static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동(행/열)
	static int N;
	static int[][] Board = new int[MAX_N][MAX_N];
	static class Point {
		int row, col;
		Point(int r, int c) {
			row = r;
			col = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				Board[i][j] = sc.nextInt();
			}
		}

		// 시작 위치 / 도작 위치
		int sRow, sCol, color;
		sRow = sc.nextInt();
		sCol = sc.nextInt();
		color = sc.nextInt();
		dfs(sRow, sCol, color);
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				System.out.println(Board[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}

	static void dfs(int r, int c, int color) {
		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Stack<Point> mystack = new Stack<>();
		mystack.push(new Point(r, c));
		
		while (!mystack.empty()) {
			Point curr = mystack.pop();
			
			if(visited[curr.row][curr.col]) continue;
			
			visited[curr.row][curr.col] = true;
			Board[curr.row][curr.col] = color;
			
			// 4방향 이웃
			for (int i = 0; i < 4; ++i) {
				int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) // 범위 영역이면 스킵
					continue;
				if (visited[nr][nc]) // 방문 한 노드이면 스킵
					continue;
				if (Board[nr][nc] == 1) // 벽이면 스킵
					continue;
				mystack.push(new Point(nr, nc));
			}
		}
	}
}
