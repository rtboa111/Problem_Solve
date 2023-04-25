package Problem_Solve;
import java.io.*;
import java.util.StringTokenizer;

public class _10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = java.lang.Integer.parseInt(br.readLine());
        Deque deq = new Deque();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (st.hasMoreTokens()) {
                switch (s) {
                    case "push_front":
                        deq.push_front(Integer.parseInt(st.nextToken()));
                        break;
                    case "push_back":
                        deq.push_back(Integer.parseInt(st.nextToken()));
                        break;
                }
            } else {
                int result = execute(s, deq);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int execute(String order, Deque deq) {
        switch (order) {
            case "pop_front":
                return deq.pop_front();
            case "pop_back":
                return deq.pop_back();
            case "size":
                return deq.size();
            case "empty":
                return deq.empty();
            case "front":
                return deq.front();
        }
        return deq.back();
    }
}
class Node2 {
    int data;
    Node2 next,prev;
    public Node2() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    private int size;
    private Node2 front,back;
    public Deque() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }
    public void push_front(int X) {
        Node2 newNode2 = new Node2();
        Node2 next = front;

        newNode2.data = X;

        if (next != null) {
            next.prev = newNode2;
        }
        front = newNode2;
        newNode2.next = next;

        if (size == 0) {
            back = newNode2;
        }
        size++;
    }

    public void push_back(int X) {
        Node2 newNode2 = new Node2();
        Node2 prev = back;

        newNode2.data = X;

        if (prev != null) {
            prev.next = newNode2;
        }
        back = newNode2;
        newNode2.prev = prev;

        if (size == 0) {
            front = newNode2;
        }
        size++;
    }
    public int pop_front() {
        if (size == 0) {
            return -1;
        }
        Node2 x = front;
        Node2 next = x.next;

        int result = x.data;

        x.data = 0;
        x.next = null;
        front = next;
        size--;
        return result;
    }
    public int pop_back() {
        if (size == 0) {
            return -1;
        }
        Node2 x = back;
        Node2 prev = x.prev;

        int result = x.data;

        x.data = 0;
        x.prev = null;
        back = prev;
        size--;
        return result;
    }
    public int size() {
        return size;
    }
    public int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }
    public int front() {
        if (size == 0) {
            return -1;
        }
        return front.data;
    }
    public int back() {
        if (size == 0) {
            return -1;
        }
        return back.data;
    }
}