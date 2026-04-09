package baekjoon.graphsearch.p1260;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        ans.append("\n");

        visited = new boolean[N + 1];
        queue.add(V);
        visited[V] = true;
        bfs();

        System.out.print(ans);
    }


    static void dfs(int idx) {

        visited[idx] = true;
        ans.append(idx).append(" ");
        for (int next : adj[idx]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.append(node).append(" ");
            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }
}
