package baekjoon.dp.p2579;

import java.io.*;

public class Main {
    static int N;
    static int[] stairsPoint;
    static int[] maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stairsPoint = new int[N+1];
        maxPoint = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stairsPoint[i] = Integer.parseInt(br.readLine());
        }

        maxPoint[1] = stairsPoint[1];

        // 이부분 조건 처리 안해줘서 런타임에러남
        if (N >= 2) {
            maxPoint[2] = stairsPoint[1] + stairsPoint[2];
        }

        for (int i = 3; i <= N; i++) {
            int case1 = maxPoint[i-2] + stairsPoint[i];
            int case2 = maxPoint[i - 3] + stairsPoint[i - 1] + stairsPoint[i];

            maxPoint[i] = Math.max(case1, case2);
        }

        System.out.println(maxPoint[N]);
    }
}
