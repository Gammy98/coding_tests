package baekjoon.bfs.p2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, region[i][j]); //최대높이 갱신
            }
        }

        int maxSafeZone  = 0;

        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int safeZoneCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (region[i][j] > h && !visited[i][j]) {
                        safeZoneCount ++;
                        bfs(i, j, h);
                    }
                }
            }
            maxSafeZone = Math.max(maxSafeZone, safeZoneCount);
        }
        System.out.println(maxSafeZone);
    }

    static void bfs(int startX, int startY, int height) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (region[nx][ny] > height) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }
}
