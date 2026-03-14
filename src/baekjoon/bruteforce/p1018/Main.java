package baekjoon.bruteforce.p1018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j];
            }
        }
        int ans =2500;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        // w 시작이락로 가정
                        if ((k + l) % 2 == (i + j) % 2) {
                            if (board[k][l].equals("B")) {
                                cnt++;
                            }
                        } else {
                            if (board[k][l].equals("W")) {
                                cnt++;
                            }
                        }
                    }
                }
                // W가 아니라 B인경우 올바른게 바껴야할 색이 되버리는거임
                int min = Math.min(cnt, 64 - cnt);
                ans = Math.min(ans, min);
            }
        }
        System.out.print(ans);
    }
}


