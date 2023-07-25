package Problem_Solve;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _4195 {

    static int[] parents, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i ++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>(F*2);
            parents = new int[F*2+1];
            cnt = new int[F*2+1];
            for (int j = 0; j <= F*2; j++) {
                parents[j] = j;
                cnt[j] = 1;
            }

            int idx = 0;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                int aNum, bNum;
                if (map.containsKey(a)) {
                    aNum = map.get(a);
                } else {
                    aNum = idx;
                    map.put(a, idx++);
                }
                if (map.containsKey(b)) {
                    bNum = map.get(b);
                } else {
                    bNum = idx;
                    map.put(b, idx++);
                }
                union(aNum, bNum);
                bw.write(String.valueOf(cnt[find(aNum)]));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return;

        parents[B] = A;
        cnt[A] += cnt[B];
    }
}