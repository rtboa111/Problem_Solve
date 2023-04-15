package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _11866 {

    public static void main(String[] args) throws IOException {
        yo<Integer> a = new yo<>();
        int[] b = a.Execution();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < b.length-1; i++) {
            sb.append(b[i]).append(", ");
        }
        sb.append(b[b.length-1]).append(">");
        System.out.println(sb);
    }
}

class Node<E> {
    public int data;
    Node<E> next;

    public Node() {
        this.data = 0;
        this.next = null;
    }
}

class yo<E> {

    public static int N,K;
    public static int size;

    public static void readIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    Node<E> head;
    Node<E> tail;

    public yo() throws IOException {
        this.head = null;
        this.tail = null;
        readIn();
        CreateYo();
    }

    public int[] Execution() {

        int[] result = new int[N];
        if (N == 1) {
            result[0] = 1;
            return result;
        }
        int j = 0;
        Node<E> x = head;
        while (j < N-1) {
            for (int i = 0; i < K-1; i++) {
                x = x.next;
            }
            result[j] = x.data;
            x = remove(x);
            j++;
        }
        result[j] = head.data;
        return result;
    }

    private Node<E> remove(Node<E> x) {

        if (size == 1) {
            return head;
        }

        Node<E> y = head;

        while (!y.next.equals(x)) {
            y = y.next;
        }
        if (x.equals(head)) {
            head = x.next;
        }
        if (x.equals(tail)) {
            tail = y;
        }
        y.next = null;
        y.next = x.next;
        x.data = 0;
        x.next = null;
        size--;
        return y.next;
    }

    private void CreateYo() {

        Node<E> x = new Node<E>();
        size = N;
        x.data = 1;
        head = x;
        if (N == 1) {
            tail = x;
            return;
        }
        for (int i = 2; i <= N; i++) {
            Node<E> y = new Node<E>();
            y.data = i;
            x.next = y;
            x = x.next;
            if (i == N) {
                tail = x;
                x.next = head;
            }
        }
    }
}
