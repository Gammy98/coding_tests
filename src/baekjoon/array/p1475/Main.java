package baekjoon.array.p1475;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] num = new int[10];
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        String numString = String.valueOf(N);
        for (int i = 0; i < numString.length(); i++) {
            num[numString.charAt(i)-'0']++;
        }

        int add69 = num[6] + num[9];
        if (add69 % 2 != 0) {
            add69 = (num[6]+num[9])/2 + 1;
        }
        else{
            add69 = (num[6]+num[9])/2;
        }
        num[6] = add69;
        num[9] = add69;

        int ans = 0;
        for (int i : num) {
            ans = Math.max(ans, i);
        }

        System.out.print(ans);
    }
}
