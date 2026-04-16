package baekjoon.etc.p1157;

import java.util.*;
import java.io.*;

public class Main {
    static int[] alp = new int[26];
    static char ans = '?';

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            alp[c - 'A']++;
        }

        int max = -1;

        for (int i = 0; i < 26; i++) {
            if (alp[i] > max) {
                max = alp[i];
                ans = (char) (i + 'A');
            } else if (alp[i] == max) {
                ans = '?';
            }
        }
        System.out.print(ans);


    }
}
