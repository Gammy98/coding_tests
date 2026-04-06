package baekjoon.graphsearch.p1987;

import java.io.*;
import java.util.*;

public class Main {
    static int L,C;
    static char[][] board;
    static boolean[] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxAns = 0;

    public static void main(String[] args) throws IOException {

        //입력과 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[L][C];
        isVisited = new boolean[26];
        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }


        isVisited[board[0][0] - 'A'] = true;
        dfs(0, 0,1);
        System.out.print(maxAns);
    }

    static void dfs(int x, int y, int cnt) {

        //현재까지 최대 이동 거리 갱신
        maxAns = Math.max(maxAns,cnt);
        if (maxAns == 26) {
            System.out.print(26);
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= L || ny < 0 || ny >= C) {
                continue;
            }

            char alp = board[nx][ny];
            if (!isVisited[alp - 'A']) {
                isVisited[alp-'A'] = true;
                dfs(nx,ny,cnt + 1);
                isVisited[alp-'A'] = false;
            }
        }
    }

}
