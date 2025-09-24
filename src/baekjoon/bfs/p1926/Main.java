package baekjoon.bfs.p1926;

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] page;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int picnum =0;
        int picmax = 0;

        page = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                page[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (page[i][j] == 1){
                    picnum++;
                    int currentarea = bfs(i, j);
                    picmax = Math.max(currentarea, picmax);
                }
            }
        }

        System.out.println(picnum);
        System.out.println(picmax);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        int area =1;
        page[x][y] = 0;//방문처리

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= n || nx <0 || ny >= m || ny<0 || page[nx][ny] != 1){
                    continue;
                }

                page[nx][ny] = 0; //방문처리
                area ++;
                queue.add(new Point(nx,ny));
            }
        }
        return area;
    }
}
