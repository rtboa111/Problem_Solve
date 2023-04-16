package Problem_Solve;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11866 {

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
            int index = Arrays.binarySearch(cardN,cardM[i]);
            if (index<0) {
                sb.append(0).append(" ");
                continue;
            }
            int count = 1;
            int next = index+1;
            while (next<N) {
                if (cardN[index]==cardN[next]) {
                    next++;
                    count++;
                } else {
                    break;
                }
            }
            int prev = index-1;
            while (prev>=0) {
                if (cardN[index]==cardN[prev]) {
                    prev--;
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
