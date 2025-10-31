package baekjoon.bfs.p2667;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map ;
    static List<Integer> houseSizes = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                if (map[i][j] == 1) {
                    houseSizes.add(bfs(i,j));
                }
            }
        }

        Collections.sort(houseSizes);
        System.out.println(houseSizes.size());

        for (int size: houseSizes){
            System.out.println(size);
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[x][y] = 0;
        int size = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= N || nx < 0 || ny < 0 || ny >= N || map[nx][ny] != 1) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                map[nx][ny] = 0;
                size ++;

            }
        }
        return size;
    }

    static class Point{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;

        }

    }

}
