package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println();
    }

}
class recur{

    public static int[] recur(int N, int count){

        int[] a = new int[2];
        if (N == 1) {
            a[0] = count;
            a[1] = N;
            return a;
        }
        if (N%3==0) {
            int[] b = recur(N/3,count);
            int[] c = recur(N-1,count);
            a[0] = Math.min(b[0],c[0]);
        } else if (N%2==0) {
            int[] b = recur(N/2,count);
            int[] c = recur(N-1,count);
            a[0] = Math.min(b[0], c[0]);
        } else {
            a = recur(N-1,count);
        }
        return recur(a[1], a[0]+1);
    }
}