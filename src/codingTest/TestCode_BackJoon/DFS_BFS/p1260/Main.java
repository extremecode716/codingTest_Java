package codingTest.TestCode_BackJoon.DFS_BFS.p1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, E; // 노드 갯수, 간선
    static int[][] Graph = null;
    static boolean[] visited = null;

    static final StringBuilder sbBfs = new StringBuilder();
    static final StringBuilder sbDfs = new StringBuilder();

    static void clearVisited() {
        Arrays.fill(visited, false);
    }

    static void dfs(int node) {
        visited[node] = true;
        sbDfs.append(node + " ");

        // 재귀적으로 stack
        for (int next = 1; next <= N; ++next) {
            if (!visited[next] && Graph[node][next] != 0) { // 방문하지 않는 노드 && 갈 수 있는 영역
                dfsTmp(next);
            }
        }
        sbDfs.setLength(sbDfs.length() - 1);
    }
    static void dfsTmp(int node) {
        visited[node] = true;
        sbDfs.append(node + " ");

        // 재귀적으로 stack
        for (int next = 1; next <= N; ++next) {
            if (!visited[next] && Graph[node][next] != 0) { // 방문하지 않는 노드 && 갈 수 있는 영역
                dfsTmp(next);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            sbBfs.append(curr + " ");
            // 인접하고 방문하지 않은 노드를 enqueue
            for (int next = 0; next <= N; ++next) {
                if (!visited[next] && Graph[curr][next] != 0) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        sbBfs.setLength(sbBfs.length() - 1);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력
            String inputStr = br.readLine();
            int[] splitNums = Arrays.stream(inputStr.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            N = splitNums[0];
            E = splitNums[1];
            Graph = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            int[] edges;
            for (int i = 1; i <= E; ++i) {
                edges = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                Graph[edges[0]][edges[1]] = Graph[edges[1]][edges[0]] = 1;
            }
            
            // 로직
            dfs(splitNums[2]);
            clearVisited();
            bfs(splitNums[2]);

            // 출력
            System.out.println(sbDfs);
            System.out.println(sbBfs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
