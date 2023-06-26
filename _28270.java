package Problem_Solve;

import java.io.*;
import java.util.*;

public class _28270 {

    static class Node {
        int idx, def;
        Node parent;
        ArrayList<Node> child;
        public Node(int idx, int def, Node parent) {
            this.idx = idx;
            this.def = def;
            this.parent = parent;
            this.child = new ArrayList<>();
        }
    }
    static int N;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        root = new Node(0, 0, null);
        int[] ans = new int[N+1];
        Node current = root;
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (current.def + 1 < cur) {
                ans[0] = -1;
                break;
            } else {
                while (current.def >= cur) {
                    current = current.parent;
                }
                Node child = new Node(i, cur, current);
                current.child.add(child);
                ans[i] = current.child.size();
                current = child;
            }
        }
        if (ans[0] == -1) {
            bw.write(-1 +"");
        } else {
            for (int i = 1; i <= N; i++) {
                bw.write(ans[i]+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}