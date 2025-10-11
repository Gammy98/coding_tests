package baekjoon.bfs.p7562;

import java.util.*;
import java.io.*;

public class Main {

    static int destx;
    static int desty;
    static  int T;
    static  int I;
    static  int[][] board;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //testcase 횟수만큼 반복
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];

            //하나의 배열로 방문처리 확인까지 해주기 위해 -1을 방문하지 않은곳으로 설정
            for (int j = 0; j < I; j++) {
                Arrays.fill(board[j], -1);
            }

            //시작위치 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int crtx = Integer.parseInt(st.nextToken());
            int crty = Integer.parseInt(st.nextToken());

            //목표위치 입력받기
            st = new StringTokenizer(br.readLine());
            destx = Integer.parseInt(st.nextToken());
            desty = Integer.parseInt(st.nextToken());

            if (crtx == destx && crty == desty) {
                System.out.println(0);
                continue;  //이걸 빼먹으면 불필요하게 담과정 계속 진행된다
            }

            //bfs돌려서 답받기
            int ans = bfs(crtx, crty);
            System.out.println(ans);
        }

    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        board[x][y] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                }

                if (board[nx][ny] == -1) {
                    board[nx][ny] = board[current.x][current.y] + 1;

                    if (nx == destx && ny == desty){
                        return board[nx][ny];
                    }
                    queue.add(new Point(nx,ny));
                }
            }

        }
        return -1;
    }

    static class Point{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
