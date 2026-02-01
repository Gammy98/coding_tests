package baekjoon.graphsearch.p4179;

import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static char[][] maze;
    static int[][] persontime;
    static int[][] firetime;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue <Point> firequeue = new LinkedList<>();
    static Queue <Point> personqueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        persontime = new int[R][C];
        firetime = new int[R][C];

        // 배열초기화
        for (int i = 0; i < R; i++) {
            Arrays.fill(firetime[i], -1);
            Arrays.fill(persontime[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'F'){
                    firequeue.add(new Point(i,j));
                    firetime[i][j] = 0;
                }

                else if (maze[i][j] == 'J'){
                    personqueue.add(new Point(i,j));
                    persontime[i][j] = 0;
                }
            }

        }

        firebfs();
        int minEscapeTime = personbfs();

        if (minEscapeTime == -1) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(minEscapeTime);
        }
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void firebfs(){
        while (!firequeue.isEmpty()) {

            Point current = firequeue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x+ dx[i];
                int ny = current.y+ dy[i];

                if (nx>=R || nx<0 || ny>=C || ny<0) {
                    continue;
                }
                if (firetime[nx][ny] >=0 || maze[nx][ny] == '#') {
                    continue;
                }

                firetime[nx][ny] = firetime[current.x][current.y] + 1;
                firequeue.add(new Point(nx,ny));
            }
        }
    }

    static int personbfs(){
        while (!personqueue.isEmpty()){

            Point current = personqueue.poll();

            //가장자리 여서 탈출하는경우
            if (current.x == 0 || current.x == R - 1 || current.y == 0 || current.y == C - 1) {
                return persontime[current.x][current.y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx>=R || nx<0 || ny>=C || ny<0) {
                    continue;
                }
                if (persontime[nx][ny] >=0 || maze[nx][ny] == '#') {
                    continue;
                }

                if (firetime[nx][ny] == -1 || persontime[current.x][current.y] + 1 < firetime[nx][ny]) {
                    persontime[nx][ny] = persontime[current.x][current.y] + 1;
                    personqueue.add(new Point(nx, ny));
                }

            }
        }
        return -1;
    }
}




