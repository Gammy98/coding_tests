package baekjoon.array.p10808;

import java.io.*;
import java.util.*;

public class Main {
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            alpha[c-'a'] ++;
        }

        for (int ans : alpha) {
            System.out.print(ans + " ");
        }
    }
}
