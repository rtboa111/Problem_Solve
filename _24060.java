package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 병합정렬(재귀함수 사용)의 과정 중에
 * 배열에 K 번째로 저장되는 원소 출력
 *
 * 해당 원소가 출력되는 시점을 특정해
 * 그 부분에 대한 병합정렬을 실행하여
 * 목적 원소 출력
 *
 * 보충 필요(좀 더 가볍고 간단한 알고리즘이 있을 것 같음)
 */
public class _24060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        marge_sort(A,0, N - 1);
        if (K > 0) {
            sb.append(-1);
        } else {
            sb.append(result);
        }
        System.out.println(sb);
    }
    public static stack stack = new stack(21);
    public static int K, N,result;
    public static boolean end = false;
    public static StringBuilder sb = new StringBuilder();

    public static void marge_sort(int[] A, int p, int r) {
        stack.put(p,r);
        if (p >= r) {
            stack.remove();
            return;
        }
        int q = (p + r) / 2;
        marge_sort(A, p, q);
        marge_sort(A,q+1,r);
        K -= r-p+1;
        if (K < 1 && !end) {
            end = true;
            marge_sort2(A, stack.P(), stack.R());
        }
        stack.remove();
    }
    public static void marge_sort2(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            marge_sort2(A, p, q);
            marge_sort2(A,q+1,r);
            marge(A, p, r);
        }
    }
    public static void marge(int[] A, int p, int r) {
        int q = (p + r) / 2;
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }
        while (i <= q) {
            temp[t++] = A[i++];
        }
        while (j <= r) {
            temp[t++] = A[j++];
        }
        i = p;
        t = 0;
        while ((i <= r)) {
            A[i++] = temp[t++];
        }
        if ((i+K-1)>=0) {
            result = A[i+K-1];
        }
    }
}

class stack {
    int[][] stack;
    int hi,lo;
    public stack(int N) {
        this.stack = new int[N][2];
        this.hi = 1;
        this.lo = 1;
    }
    public void put(int p,int r) {
        stack[hi][0] = p;
        stack[hi++][1] = r;
    }
    public void remove() {
        stack[--hi][0] = stack[hi][1] = 0;
    }
    public int P() {
        return stack[--hi][0];
    }
    public int R() {
        return stack[hi][1];
    }
}
