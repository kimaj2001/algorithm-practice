package algorithm.backjoon.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs {
    /**
     * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
     * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
     * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
     *
     * [입력]
     * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
     * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
     * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
     *
     * [출력]
     * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
     */
    // 해당 노드에 방문한적 있는지 체크하기 위해 boolean 배열 선언
    static boolean[] visited;
    // bfs에서 사용할 Queue 선언
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        // 값 입력받기(node, line, index)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        // 입력받은 값들을 2차원 배열로 생성
        int[][] graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 정점간 간선이 있는 경우 1로 선언
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v, graph);
        System.out.println();
        // dfs 수행 후 visited 배열 재사용을 위해 false로 초기화
        Arrays.fill(visited, false);
        bfs(v, graph);
    }

    private static void dfs(int v, int[][] graph) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i] && graph[v][i] == 1) dfs(i, graph);
        }
    }

    private static void bfs(int v, int[][] graph) {
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");
            for (int i = 1; i < graph.length; i++) {
                if (graph[idx][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
