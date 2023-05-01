package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        StringBuilder sb = new StringBuilder();
        for (int i =0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.empty()).append("\n");
                    break;
                case "front":
                    sb.append(q.front()).append("\n");
                    break;
                case "back":
                    sb.append(q.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}
class Node {
    public int data;
    public Node next;
    Node() {
        this.data = 0;
        this.next = null;
    }
}
class Queue {
    private int size;
    private Node front,rear;
    Queue() {
        this.size = 0;
        this.front = this.rear = null;
    }
    void push(int x) {
        Node a = new Node();
        a.data = x;
        if (size==0) {
            front = rear = a;
        }
        rear.next = a;
        rear = a;
        size++;
    }
    int pop() {
        if (size==0) {
            return -1;
        }
        Node x = front;
        int temp = x.data;
        front = x.next;
        x = null;
        size--;
        return temp;
    }
    int size() {
        return size;
    }
    int empty() {
        if (size==0) {
            return 1;
        }
        return 0;
    }
    int front() {
        if (size==0) {
            return -1;
        }
        return front.data;
    }
    int back() {
        if (size==0) {
            return -1;
        }
        return rear.data;
    }
}

