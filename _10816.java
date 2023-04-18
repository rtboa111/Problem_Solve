package Problem_Solve;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
    중복값이 있을 경우 binarySearch 의 upper bound 와
    lower bound 활용
 */
public class _10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardN = new int[N];
        for (int i = 0; i < N; i++) {
            cardN[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cardM = new int[M];
        for (int i = 0; i <M; i++) {
            cardM[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cardN);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            int index = binarySearchLower(cardN, cardM[i]);
            int index2 = binarySearchUpper(cardN, cardM[i]);
            sb.append(index2-index).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public static int binarySearchLower(int[] a, int b) {

        int start = 0;
        int end = a.length;
        while (start<end) {
            int mid = (start+end)/2;
            if (a[mid] >= b) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static int binarySearchUpper(int[] a, int b) {

        int start = 0;
        int end = a.length;
        while (start<end) {
            int mid = (start+end)/2;
            if (a[mid] > b) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
