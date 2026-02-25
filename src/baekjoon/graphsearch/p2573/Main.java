package baekjoon.graphsearch.p2573;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {

            int cnt = 0; // 덩어리 개수 세기
            visited = new boolean[N][M]; // 방문기록 매년 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ice[i][j] > 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2) {
                System.out.println(year);
                break;
            } else if (cnt == 0) {
                System.out.println(0);
                break;
            }

            melt(); //빙산 녹이기
            year++;
        }
    }


    static void melt() {
        int[][] next = new int[N][M]; //높이 반영한 복사본

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] > 0) {
                    int temp = 0; // 줄어들 높이
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && ice[nx][ny] == 0) {
                            temp++;
                        }
                    }
                    next[i][j] = Math.max(0, ice[i][j] - temp); //if 대신 math로
                }
            }
        }
        ice = next; //배열 복사
    }

    static void bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (ice[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx,ny));
                }

            }
        }
    }

    static class Point{
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
