package baekjoon.recursive.p1074;

import java.util.*;
import java.io.*;

public class Main {
    static int N,r,c;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.print(func(N,r,c));
    }

    static int func(int n, int r, int c) {
        int half = 1 << n - 1;
        if (n == 0) {
            return 0;
        }else if (r < half && c < half) {
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        }else{
            return 3 * half * half + func(n - 1, r - half, c-half);
        }
    }
}
