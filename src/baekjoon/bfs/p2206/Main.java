package baekjoon.bfs.p2206;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;  //broken 유무 표시를 위해 3차원으로
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Deque<Point> queue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        queue.add(new Point(0, 0,1,0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == N-1 && curr.y == M-1) {  //-1 주의
                System.out.print(curr.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0) {

                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][curr.broken]) {
                        visited[nx][ny][curr.broken] = true;
                        queue.add(new Point(nx, ny, curr.dist + 1, curr.broken));

                    }
                } else if (map[nx][ny] == 1) {
                    if (curr.broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Point(nx, ny, curr.dist + 1, 1));
                    }
                }
            }
        }
        System.out.print(-1);
    }

    static class Point {
        int x, y, dist, broken ;

        Point(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;  //0 은 아직 기회가 남은것
        }
    }
}
