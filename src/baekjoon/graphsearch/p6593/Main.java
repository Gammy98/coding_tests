package baekjoon.graphsearch.p6593;

import java.io.*;
import java.util.*;

public class Main {

    static int L,R,C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Deque<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input ==null||input.isEmpty()){
                input = br.readLine();
            }
            StringTokenizer st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            queue = new ArrayDeque<>();

            int escatpe_time = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String row = br.readLine();
                    if (row.isEmpty()) row = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = row.charAt(k);
                        building[i][j][k] = c;
                        if (c == 'S') {
                            queue.add(new Point(j, k, i,0));
                            visited[i][j][k] = true;
                        }
                    }
                }
            }
            bfs();
        }
    }

    static class Point{
        int x,y,z,t;

        Point(int x, int y,int z,int t) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (building[curr.z][curr.x][curr.y] == 'E') {
                System.out.println("Escaped in " + curr.t + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int nz = curr.z + dz[i];

                if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nz][nx][ny] && building[nz][nx][ny] != '#') {
                        visited[nz][nx][ny] = true;
                        queue.add(new Point(nx, ny, nz, curr.t + 1));
                    }
                }
            }
        }
        System.out.println("Trapped!");
    }
}

