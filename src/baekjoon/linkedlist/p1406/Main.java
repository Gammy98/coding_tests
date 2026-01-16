package baekjoon.linkedlist.p1406;

import java.io.*;
import java.util.*;

public class Main {
    static String N;
    static int M;

    static int cursor = 0;
    static int unused = 1;
    static char[] dat = new char[600005];
    static int[] pre = new int[600005];
    static int[] nxt = new int[600005];


    public static void main(String[] args) throws IOException{

        Arrays.fill(pre,-1);
        Arrays.fill(nxt,-1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            insert(cursor, N.charAt(i));
            cursor = nxt[cursor]; //삽입 후 커서를 새로 생긴 노드로 이동
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char op = line.charAt(0);

            if (op == 'L') {
                if (pre[cursor] != -1) {
                    cursor = pre[cursor];
                }
            }

            else if (op == 'R') {
                if (nxt[cursor] != -1) {
                    cursor = nxt[cursor];
                }
            } else if (op == 'B') {
                if (cursor != 0) {
                    erase(cursor);
                    cursor = pre[cursor];
                }

            } else if (op == 'P') { //명령어 B인경우
                char add = line.charAt(2);
                insert(cursor, add);
                cursor = nxt[cursor];
            }
        }
        traverse();
    }

    public static void insert(int addr, char val) {
        dat[unused] = val;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];

        if (nxt[addr] != -1) {
            pre[nxt[addr]] = unused;
        }
        nxt[addr] = unused;
        unused++;

    }
    public static void erase(int addr){
        nxt[pre[addr]] = nxt[addr];
        if (nxt[addr] != -1) {
            pre[nxt[addr]] = pre[addr];
        }
    }

    public static void traverse(){
        StringBuilder sb = new StringBuilder();
        int cur = nxt[0];
        while (cur != -1) {
            sb.append((char) dat[cur]);
            cur = nxt[cur];
        }
        System.out.println(sb);
    }
}

// 앞위로 한칸씩 밖에 안움직여 굳이 linked list를 쓰지않고 +1 -1 로 할 수 있다 생각했으나
// insert,erase 마다 나머지 데이터가 다 움직여야하므로 불가