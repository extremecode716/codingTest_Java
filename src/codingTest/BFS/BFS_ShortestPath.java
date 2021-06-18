package codingTest.BFS;

import java.io.*;
import java.util.*;
public class BFS_ShortestPath {
	static final int MAX_N = 10;
	static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동(행/열)
	static int N;
	static int[][] Board = new int[MAX_N][MAX_N];
	static class Point {
		int row, col, dist;
		Point(int r, int c, int d) {
			row = r;
			col = c;
			dist = d;
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
		int sRow, sCol, dRow, dCol;
		sRow = sc.nextInt();
		sCol = sc.nextInt();
		dRow = sc.nextInt();
		dCol = sc.nextInt();
		System.out.println(bfs(sRow, sCol, dRow, dCol));

		sc.close();
	}

	static int bfs(int sRow, int sCol, int dRow, int dCol) {
		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Queue<Point> myqueue = new LinkedList<>();
		visited[sRow][sCol] = true;
		myqueue.add(new Point(sRow, sCol, 0)); // 시작 위치

		while (!myqueue.isEmpty()) {
			Point curr = myqueue.remove();
			// 도착
			if (curr.row == dRow && curr.col == dCol) {
				return curr.dist;
			}

			// 4방향 이웃
			for (int i = 0; i < 4; ++i) {
				int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) // 범위 영역이면 스킵
					continue;
				if (visited[nr][nc]) // 방문 한 노드이면 스킵
					continue;
				if (Board[nr][nc] == 1) // 벽이면 스킵
					continue;
				visited[nr][nc] = true; // 방문 체크
				myqueue.add(new Point(nr, nc, curr.dist + 1));
			}
		}

		return -1;
	}
}
