package baekjoon.graphsearch.p6603;

import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static StringBuilder sb = new StringBuilder();;
    static int[] arr;
    static int[] lotto = new int[6];

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //로직
            combination(0,0);
            sb.append("\n");
        }
        //출력
        System.out.print(sb);
    }

    static void combination(int start, int cnt) {
        if (cnt == 6) {
            for (int val : lotto) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= K-(6-cnt); i++) {
            lotto[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }
}
