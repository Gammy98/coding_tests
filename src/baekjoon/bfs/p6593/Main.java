package baekjoon.bfs.p6593;

import java.io.*;
import java.util.*;

public class Main {

    static int L,R,C;
    static char[][][] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        building = new char[L][R][C];

        int escatpe_time = 0;

        //building 초기화
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    building[L][R][C] = st.nextToken().charAt(k);
                }
            }
        }


    }

}

