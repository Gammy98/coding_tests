package baekjoon.array.p1919;

import java.io.*;
import java.util.*;

public class Main {
    static int[] alp1 = new int[26];
    static int[] alp2 = new int[26];
    static String word1,word2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word1 = br.readLine();
        word2 = br.readLine();

        for (int i = 0; i < word1.length(); i++) {
            char target = word1.charAt(i);
            alp1[target-'a'] ++;
        }

        for (int i = 0; i < word2.length(); i++) {
            char target = word2.charAt(i);
            alp2[target-'a'] ++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(alp1[i] - alp2[i]);
            if (diff > 0) {
                ans += diff;
            }
        }
        System.out.println(ans);
    }
}
