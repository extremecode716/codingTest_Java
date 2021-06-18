package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
import java.util.*;
// https://level.goorm.io/exam/43082/%EC%B5%9C%EB%8B%A8-%EA%B1%B0%EB%A6%AC-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1
public class 최단거리구하기_lv3 {
	static int MAX_N = 10;
	static int[][] board = new int[MAX_N][MAX_N];
	static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
	static int N;
	static class Point {
		int row, col, dist;
		Point(int r, int c, int d) {
			row = r;
			col = c;
			dist = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input);

		// 값 세팅 1: 길 , 0: 없는 길
		for (int i = 0; i < N; ++i) {
			String[] cols = br.readLine().split(" ");
			for (int j = 0; j < cols.length; ++j) {
				board[i][j] = Integer.parseInt(cols[j]);
			}
		}

		// 시작 위치, 도착위치
		int sRow, sCol, dRow, dCol;
		sRow = 0;
		sCol = 0;
		dRow = N - 1;
		dCol = N - 1;
		System.out.println(bfs(sRow, sCol, dRow, dCol));

		br.close();
	}

	static int bfs(int sRow, int sCol, int dRow, int dCol) {
		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Queue<Point> myqueue = new LinkedList<>();
		visited[sRow][sCol] = true;
		myqueue.add(new Point(sRow, sCol, 1)); // 시작 위치

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
				if (board[nr][nc] == 0) // 벽이면 스킵
					continue;
				visited[nr][nc] = true; // 방문 체크
				myqueue.add(new Point(nr, nc, curr.dist + 1));
			}
		}

		return -1;
	}
}
