package baekjoon.dp.p1463;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] D;  // D[i] : 숫자 i를 1로 만드는 데 필요한 최소 연산 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        D = new int[N+1]; //0으로 자동 초기화되어있음 D[1] = 0

        for (int i = 2; i <= N; i++) {
            //1을 빼는 연산
            D[i] = D[i - 1] + 1;

            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i/2] + 1);
            }

            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i/3] + 1);
            }

        }
        System.out.println(D[N]);
    }
}
