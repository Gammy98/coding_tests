package baekjoon.bfs.p2178;

import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static int N;
    static  int[][] nums;
    static int[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static  Queue <Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        nums = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(nums[i], 0);
        }
        nums[0][0] = 1;


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j)-'0';
            }
        }

        queue.add(new Point(0,0));
        bfs();
        System.out.println(nums[N-1][M-1]);

        return;
    }

    static class Point {
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()){
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (maze[nx][ny] == 0 || nums[nx][ny] != 0 ){
                    continue;
                }
                nums[nx][ny] = nums[current.x][current.y] + 1;
                queue.add(new Point(nx,ny));
            }

        }
    }


}
