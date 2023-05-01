package Problem_Solve;

import java.io.*;

public class _1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write(heap.remove()+"\n");
            } else {
                heap.add(x);
            }
        }
        bw.flush();
        bw.close();
    }
}

class Heap {
    int[] arr;
    int size;
    public Heap(int N) {
        this.arr = new int[N+1];
        this.size = 0;
    }
    private int parent(int c) {
        return c >> 1;
    }
    private int childL(int p) {
        return p << 1;
    }
    private int childR(int p) {
        return (p << 1) + 1;
    }
    public void add(int x) {    // sift-up
        if (size++ == 0) {
            arr[1] = x;
            return;
        }
        int idx = size;
        while (idx > 1) {
            int p = parent(idx);
            int pVal = arr[p];
            if (pVal < x) {
                break;
            }
            arr[idx] = pVal;
            idx = p;
        }
        arr[idx] = x;
    }
    public int remove() {   // sift-down
        if (size == 0) {
            return 0;
        }
        int x = arr[size--];
        int p = 1;
        int c;
        int result = arr[p];
        arr[p] = 0;
        while ((c = childL(p)) <= size) {
            int cVal = arr[c];
            int cR = childR(p);
            if (cR <= size && cVal > arr[cR]) {
                c = cR;
                cVal = arr[c];
            }
            if (cVal > x) {
                break;
            }
            arr[p] = cVal;
            p = c;
        }
        arr[p] = x;
        return result;
    }
}