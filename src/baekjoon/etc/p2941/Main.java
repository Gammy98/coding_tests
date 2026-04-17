package baekjoon.etc.p2941;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] croatia = {"dz=","c=", "c-", "d-", "lj", "nj", "s=", "z="};
        for (String val : croatia){
            if (input.contains(val)) {
                input = input.replace(val, "@");
            }
        }
        System.out.println(input.length());
    }
}
