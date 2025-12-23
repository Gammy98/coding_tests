package baekjoon.array.p13300;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] student = new int[7][2];
    static int room = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            student[grade][sex] ++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                int target = student[j][i];
                if (target % K != 0) {
                    room += target / K + 1;
                }
                else{
                    room += target / K;
                }
                // if else 대신에 room += (target + K - 1) / K; 한줄로 올림처리가 가능해진다
            }
        }

        System.out.print(room);
    }
}
