package Problem_Solve;


import java.io.*;

public class _5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i+2 < M; i++) {
            int temp = 0;
            while (i+2 < M && S[i] == 'I' && S[i+1] == 'O' && S[i+2] == 'I') {
                temp++;
                i+=2;
            }
            if (temp >= N) {
                count += temp - (N - 1);
            }
        }
        System.out.println(count);
    }
}