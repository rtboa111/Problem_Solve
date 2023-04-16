package Problem_Solve;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardN = new int[N];
        for (int i = 0; i < N; i++) {
            cardN[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cardM = new int[M];
        for (int i = 0; i < M; i++) {
            cardM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardN);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            value = cardM[i];
            sb.append(Duplication(cardN)).append(" ");
        }
        System.out.println(sb);
    }
    public static int value,N,M;

    public static int BSearch(int[] arr) {

        int index = -1;
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;

        while (start!=end) {
            if (arr[mid]==value) {
                index = mid;
                return index;
            } else if (arr[mid] < value) {
                start = mid;
                mid = (start+end)/2 + 1;
            } else {
                end = mid-1;
                mid = (start+end)/2 + 1;
            }
        }
        if (arr[start]==value) {
            index = start;
        }
        return index;
    }
    public static int Duplication(int[] arr) {

        int index = BSearch(arr);
        if (index==-1) {
            return 0;
        }
        int count = 1;
        int next = index+1;
        while (next<N) {
            if (arr[index]==arr[next]) {
                next++;
                count++;
            } else break;
        }
        int prev = index-1;
        while (prev>=0) {
            if (arr[index]==arr[prev]) {
                prev--;
                count++;
            } else break;
        }
        return count;
    }
}

