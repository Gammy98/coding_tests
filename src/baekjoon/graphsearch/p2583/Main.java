package baekjoon.graphsearch.p2583;

import java.io.*;
import java.util.*;

public class Main {
    static int M,N,K;
    static boolean[][] page;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        page = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            visited(x1,y1,x2,y2);
        }

        List<Integer> areaSizes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (page[i][j] == false) {
                    areaSizes.add(bfs(i,j));
                }
            }
        }

        Collections.sort(areaSizes);
        System.out.println(areaSizes.size());

        StringBuilder sb = new StringBuilder();
        for (int size : areaSizes) {
            sb.append(size).append(" ");
        }
        System.out.println(sb.toString().trim()); //trim해주는 이유..?
    }
    static int bfs(int x,int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        page[x][y] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || page[nx][ny] == true) {
                    continue;
                }
                queue.add(new Point(nx, ny));
                page[nx][ny] = true;
                area ++;
            }
        }
        return area;
    }

    static void visited(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (!page[i][j]) {
                    page[i][j] = true;
                }
            }
        }
    }

    static class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
