package codingTest.DFS;
// DFS (Depth First Search)
// 깊이 우선 탐색
// 시작 노드에서 깊이가 커지는 방향으로 탐색을 진행하여 더 이상 방문할 인접 노드가 없는 경우 이전
// 노드가 돌아가서, 다시 깊이 우선 탐색을 반복하게 된다.
// https://www.youtube.com/watch?v=0Njv04WiLV0&list=PL6YHvWRMtz7CbOmh5Id4DERE5gyQC50XS&index=2
import java.util.*;

public class DFS_Stack {
	static final int MAX_N = 10;
	static int N, E; // 노드 갯수, 간선
	static int[][] Graph = new int[MAX_N][MAX_N];

	static void dfs(int node) {
		boolean[] visited = new boolean[MAX_N];

		Stack<Integer> mystack = new Stack<>();
		mystack.push(node);

		while (!mystack.empty()) {
			int curr = mystack.pop();

			if (visited[curr])
				continue;

			visited[curr] = true;
			System.out.println(curr + " ");

			for (int next = 0; next < N; ++next) {
				if (!visited[next] && Graph[node][next] != 0) { // 방문하지 않는 노드 &&
																// 갈 수 있는 영역
					mystack.push(next);
				}
			}
		}
		/*
		 * // 재귀적으로 stack for(int next = 0; next < N; ++next) {
		 * if(!Visited[next] && Graph[node][next] != 0) { // 방문하지 않는 노드 && 갈 수
		 * 있는 영역 dfs(next); } }
		 */
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		for (int i = 0; i < E; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] = 1; // 인접 노드 // 길
		}
		dfs(0);
	}

}
