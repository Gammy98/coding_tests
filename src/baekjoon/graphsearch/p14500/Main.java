package baekjoon.graphsearch.p14500;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] page;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isVisited;
    static int maxAns = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        page = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                page[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, page[i][j]);
                isVisited[i][j] = false;
            }
        }

        System.out.print(maxAns);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            maxAns = Math.max(maxAns, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 1. 범위 체크
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 2. 이미 방문한 칸이면 건너뜀 (공통 조건)
            if (isVisited[nx][ny]) continue;

            // 3. 'ㅗ' 모양 특수 처리 (cnt == 2일 때)
            if (cnt == 2) {
                isVisited[nx][ny] = true;
                dfs(x, y, cnt + 1, sum + page[nx][ny]); // 위치는 (x, y) 그대로!
                isVisited[nx][ny] = false;
            }

            // 4. 일반적인 DFS 이동 (모든 cnt에서 수행)
            isVisited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + page[nx][ny]); // 위치를 (nx, ny)로 이동!
            isVisited[nx][ny] = false;
        }
    }
}
