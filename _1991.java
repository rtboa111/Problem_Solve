package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1991 {

    static class Node {
        Node left;
        Node right;
        char name;
        public Node(char name) {
            this.name = name;
            this.left = this.right = null;
        }
    }
    static ArrayList<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        res = new String[3];
        res[0] = ""; res[1] = ""; res[2] = "";
        nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node((char) (i + 'A')));
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            if (left >= 0) {
                nodes.get(parent).left = nodes.get(left);
            }
            if (right >= 0) {
                nodes.get(parent).right = nodes.get(right);
            }
        }
        Node cur = nodes.get(0);
        front(cur);
        mid(cur);
        rear(cur);

        for (String s : res) {
            System.out.println(s);
        }
    }
    static String[] res;
    static void front(Node cur) {
        res[0] += cur.name;

        if (cur.left != null) {
            front(cur.left);
        }

        if (cur.right != null) {
            front(cur.right);
        }
    }
    static void mid(Node cur) {

        if (cur.left != null) {
            mid(cur.left);
        }

        res[1] += cur.name;

        if (cur.right != null) {
            mid(cur.right);
        }

    }
    static void rear(Node cur) {

        if (cur.left != null) {
            rear(cur.left);
        }

        if (cur.right != null) {
            rear(cur.right);
        }

        res[2] += cur.name;
    }
}
