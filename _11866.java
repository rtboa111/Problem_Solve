package Problem_Solve;


import java.io.*;
import java.util.StringTokenizer;

public class _11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    }

    public static int N,K;
}

class Node<E> {
    private int data;
    Node<E> next;

    public Node() {
        this.data = 0;
        this.next = null;
    }
}

class yo<E> {

    Node<E> head;
    Node<E> tail;

    public yo() {
        this.head = null;
        this.tail = null;
    }

    public void CreateYo(int N) {
        Node<E> x = head;
        for (int i = 0; i < N; i++) {

        }
    }
}
