package Problem_Solve;

import java.io.*;
import java.util.*;

public class _13172 {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long nPrev = Long.parseLong(st.nextToken());
        long sPrev = Long.parseLong(st.nextToken());
        for (int i = 1; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long nCur = Long.parseLong(st.nextToken());
            long sCur = Long.parseLong(st.nextToken());
            sCur *= nPrev;
            sPrev *= nCur;
            nPrev *= nCur;
            sPrev %= MOD; sCur %= MOD; nPrev %= MOD;
            sPrev = (sPrev + sCur) % MOD;
        }
        long gcd = gcd(sPrev, nPrev);
        nPrev /= gcd; sPrev /= gcd;
        long res = (nPrev == 1) ? sPrev : (divideConquer(nPrev) * sPrev) % MOD;
        System.out.println(res);
    }
    static long divideConquer(long n) {
        long multiLater = 1;
        int mod = MOD-2;
        while (mod > 1) {
            multiLater *= (mod % 2 == 1) ? n : 1;
            multiLater %= MOD;
            n = n * n;
            n %= MOD;
            mod /= 2;
        }
        return (n * multiLater) % MOD;
    }
    static long gcd(long p, long q) {
        return (q == 0) ? p : gcd(q, p % q);
    }
}