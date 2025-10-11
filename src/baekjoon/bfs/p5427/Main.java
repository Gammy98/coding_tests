package baekjoon.bfs.p5427;

import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int w,h;
    static char[][] building;
    static int[][] man,fire;
    static Queue<Point> firequeue, manqueue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            fire = new int[w][h];
            man = new int[w][h];

            for (int j = 0; j < w; j++) {
                Arrays.fill(fire[j],-1);
            }

            for (int j = 0; j < w; j++) {
                Arrays.fill(man[j],-1);
            }

            firequeue = new LinkedList<>();
            manqueue = new LinkedList<>();

            building = new char[w][h];
            for (int j = 0; j < w; j++) {
                String input = br.readLine();
                for (int k = 0; k < h; k++) {
                    building[j][k] =  input.charAt(k);
                    if (building[j][k] == '*') {
                        firequeue.add(new Point(j,k));
                        fire[j][k] = 0;
                    }
                    if (building[j][k] == '@'){
                        manqueue.add(new Point(j, k));
                        man[j][k] = 0;
                    }
                }
            }

            firebfs();
            int answer = manbfs();
            if (answer == -1) {
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(answer);
            }
        }
    }

    static void firebfs() {

        while (!firequeue.isEmpty()) {
            Point current = firequeue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                    continue;
                }
                if (fire[nx][ny] == -1 && (building[nx][ny] == '.' || building[nx][ny] == '@')) {
                    fire[nx][ny] = fire[current.x][current.y] + 1;
                    firequeue.add(new Point(nx, ny));
                }
            }

        }
    }

    static int manbfs() {
        while (!manqueue.isEmpty()) {
            Point current = manqueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                    return man[current.x][current.y] + 1;
                }

                if (man[nx][ny] != -1 || building[nx][ny] == '#') continue;

                int nextManTime = man[current.x][current.y] + 1;

                if (fire[nx][ny] == -1 || nextManTime < fire[nx][ny]) {
                    man[nx][ny] = nextManTime;
                    manqueue.add(new Point(nx, ny));
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//불이 여러군데서 오는경우 같은 칸이더라도 어디서 불이 먼저 오는지 체크하기
//불과 사람의 이동순서 주의