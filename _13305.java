package Problem_Solve;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N-1];
        int[] oilCost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oilCost[i] = Integer.parseInt(st.nextToken());
        }
        int min = oilCost[0];
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < N-1; i++) {
            if (min > oilCost[i]) {
                min = oilCost[i];
            }
            BigInteger tmp = BigInteger.valueOf(min).multiply(BigInteger.valueOf(distance[i]));
            result = result.add(tmp);
        }
        System.out.println(result);
    }
}