package Problem_Solve;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = operation(st.nextToken(),stack);
            if (a==-2) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else {
                sb.append(a).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int operation(String s,Stack stack) {
        if (s.equals("pop")) {
            return stack.pop();
        } else if (s.equals("size")) {
            return stack.size();
        } else if (s.equals("empty")) {
            return stack.empty();
        } else if (s.equals("top")) {
            return stack.top();
        }
        return -2;
    }
}
class Stack {
    private int[] arr;
    private static int Default = 10;
    private int capacity;
    private int size;

    public Stack() {
        this.arr = new int[Default];
        this.capacity = Default;
        this.size = 0;
    }
    public void resizing() {
        if (size==0) {
            arr = new int[Default];
            return;
        }
        int arrayCapacity = arr.length;
        if (size==arrayCapacity) {
            arrayCapacity *= 2;
            arr = Arrays.copyOf(arr, arrayCapacity);
        } else if (size<arrayCapacity/2) {
            arrayCapacity/=2;
            arr = Arrays.copyOf(arr, Math.max(arrayCapacity,Default));
        }
    }
    public void push(int x) {
        if (size==arr.length) {
            resizing();
        }
        arr[size] = x;
        size++;
    }
    public int pop() {
        if (size==0) {
            return -1;
        }
        size--;
        int result = arr[size];
        arr[size] = 0;
        resizing();
        return result;
    }
    public int size() {
        return size;
    }
    public int empty() {
        if (size==0) {
            return 1;
        }
        return 0;
    }
    public int top() {
        if (size==0) {
            return -1;
        }
        return arr[size-1];
    }
}

