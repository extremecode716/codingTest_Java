package codingTest.T_카카오2021_04_합승택시요금;
// Floyd-Warshall, 완전 탐색(Exhaustive Search, Brute Force)
import java.util.*;

class Solution {
	static final int INF = 200 * 100000 + 1;
	int[][] dist = new int[200][200];

	void floyd(int n) {
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = INF;
				}
			}
		}

		for (int[] edge : fares) {
			dist[edge[0] - 1][edge[1] - 1] = edge[2];
			dist[edge[1] - 1][edge[0] - 1] = edge[2];
		}

		floyd(n);
		
		--s;
		--a;
		--b;

		int answer = INF;
		for(int k = 0; k < n; ++k) {
			answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
		}
		
		return answer;
	}
}

public class T_카카오2021_04_합승택시요금 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(6, 4, 6, 2,
				new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));

	}

}
