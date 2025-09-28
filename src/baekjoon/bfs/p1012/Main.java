package baekjoon.bfs.p1012;

import java.util.*;
import java.io.*;

public class Main {
    static int T,M,N,K;
    static int[][] ground;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int bug = 0;
            ground = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                ground[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ground[j][k] == 1) {
                        bug ++;
                        bfs(j,k);
                    }
                }
            }
            System.out.println(bug);
        }


    }

    static class Point {
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || ground[nx][ny] == 0) {
                    continue;
                }

                ground[nx][ny] = 0;
                queue.add(new Point(nx, ny));
            }

        }

    }

}
