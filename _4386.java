package Problem_Solve;

import java.io.*;
import java.util.*;

public class _4386 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<float[]> star = new ArrayList<>(n);
        ArrayList<float[]> graph = new ArrayList<>(n*n);
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            star.add(new float[]{Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken())});
            parents[i] = i;
        }

        int idx = 0;
        for (float[] i : star) {
            float x = i[0];
            float y = i[1];
            for (int j = idx+1; j < n; j++) {
                float[] cur = star.get(j);
                float distX = Math.abs(x - cur[0]);
                float distY = Math.abs(y - cur[1]);
                float dist = (float) Math.pow(distX*distX + distY*distY, 0.5);
                graph.add(new float[]{dist, j, idx});
            }
            idx++;
        }
        graph.sort(((o1, o2) -> Float.compare(o1[0], o2[0])));

        int cnt = 0;
        float cost = 0;
        for (float[] i : graph) {
            if (union((int) i[1], (int) i[2])) {
                cost += i[0];
                cnt++;
                if (cnt >= n-1) {
                    break;
                }
            }
        }
        System.out.println(cost);
    }
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;

        parents[A] = B;
        return true;
    }
}