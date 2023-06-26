package Problem_Solve;

import java.io.*;
import java.util.ArrayList;

public class _5639 {

    static class Node {
        int num;
        Node l, r;
        public Node(int num) {
            this.num = num;
            this.l = this.r = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        Node next; Node cur = null; Node root = null;
        int cnt = 0;
        while ((input = br.readLine()) != null) {
            cnt++;
            int num = Integer.parseInt(input);
            if (cur == null) {
                cur = new Node(num);
                root = cur;
                continue;
            }
            cur = root;
            next = new Node(num);
            while ((cur.l != null && cur.num > num) || cur.r != null && cur.num < num) {
                if (cur.l != null && cur.num > num) {
                    cur = cur.l;
                }
                if (cur.r != null && cur.num < num) {
                    cur = cur.r;
                }
            }
            if (cur.num > num) {
                cur.l = next;
            } else {
                cur.r = next;
            }
        }
        res = new ArrayList<>(cnt);
        dfs(root);
        for (int i : res) {
            bw.write(i+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static ArrayList<Integer> res;
    static void dfs(Node cur) {
        if (cur.l != null) {
            dfs(cur.l);
        }
        if (cur.r != null) {
            dfs(cur.r);
        }
        res.add(cur.num);
    }
}