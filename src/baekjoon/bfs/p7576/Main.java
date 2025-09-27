package baekjoon.bfs.p7576;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] box;
    static int[][] day;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //M,N입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        //박스입력받기
        box = new int[N][M];
        day = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st2.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j));
                    day[i][j] = 0;  //첫번째 시작이니까 0일로 설정
                }
                else {
                    day[i][j] = -1;
                }
            }
        }

        bfs();

        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0 && day[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(day[i][j], maxDay);

            }
        }
        System.out.println(maxDay);


    }

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        while (!queue.isEmpty()){
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >=0 && nx <N && ny>=0 && ny<M && box[nx][ny] ==0 && day[nx][ny] == -1){
                    day[nx][ny] = day[current.x][current.y] + 1;
                    queue.add(new Point (nx,ny));
                }
            }
        }
    }


}


