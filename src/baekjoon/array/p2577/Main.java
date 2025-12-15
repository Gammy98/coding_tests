package baekjoon.array.p2577;

import java.io.*;

public class Main {

    static int[] num = new int[10];
    static int A,B,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int number = A*B*C;
        String numString = String.valueOf(number);
        for (int i = 0; i < numString.length(); i++) {
            int n = numString.charAt(i)-'0';
            num[n]++;
        }

        for (int i : num) {
            System.out.println(i);
        }
    }
}
