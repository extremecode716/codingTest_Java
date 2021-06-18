package codingTest.BFS;
// BFS: Breadth First Search
// 너비 우선 탐색
// 시작 노드에서 인접 노드를 모두 방문하고, 방문한 노드에서 인접 노드를 모두 방문하는 것을 반복하게 된다.
//https://www.youtube.com/watch?v=yQ7o1Y7X_Rg&list=PL6YHvWRMtz7CbOmh5Id4DERE5gyQC50XS
import java.util.*;

public class BFS {
	static final int MAX_N = 10;
	static int N, E; // 노드 갯수, 간선
	static int[][] Graph = new int[MAX_N][MAX_N];
	
	static void bfs(int node) {
		boolean[] visited = new boolean[MAX_N];
		
		Queue<Integer> myqueue = new LinkedList<>();
		visited[node] = true; // 마킹만
		myqueue.add(node);
		
		while(!myqueue.isEmpty()) {
			int curr = myqueue.remove();
			
			System.out.println(curr + " "); // 실제 방문
			
			// 인접하고 방문하지 않은 노드를 enqueue
			for(int next = 0; next < N; ++next) {
				if(!visited[next] && Graph[curr][next] != 0) {
					visited[next] = true;
					myqueue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		for(int i = 0; i < E; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] = 1;
		}
		bfs(0);

		sc.close();
	}

}
