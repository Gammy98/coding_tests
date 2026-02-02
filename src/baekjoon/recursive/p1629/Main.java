package baekjoon.recursive.p1629;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(multiple(A,B,C));
    }

    static long multiple(long a, long b, long c) {

        if (b == 1) {
            return a % c;
        }

        long val = multiple(a, b / 2, c);
        val = val * val % c; // 만약에 2n인경우

        if (b % 2 == 0) {
            return val;
        }

        return val * a % c; // 만약에 2n + 1 인경우
    }
}
