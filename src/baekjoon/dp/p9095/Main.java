package baekjoon.dp.p9095;

import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int[] D = new int[11];

    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for (int i = 4; i < 11; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(D[n]).append('\n');
        }
        System.out.println(sb);
    }
}

