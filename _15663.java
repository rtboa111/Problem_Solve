package Problem_Solve;

import java.io.*;
import java.util.*;

public class _15663 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<int[]> set;
    static boolean[] check;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new ArrayList<>();
        check = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        arr(new int[M], 0);

        Collections.sort(set, ((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] != o2[i]) {
                    return o1[i] - o2[i];
                }
            }
            return 0;
        }));

        loop:
        for (int i = 1; i < set.size(); i++) {
            int[] o1 = set.get(i-1);
            int[] o2 = set.get(i);
            for (int j = 0; j < o1.length; j++) {
                if (o1[j] != o2[j]) {
                    continue loop;
                }
            }
            set.remove(i);
            i--;
        }

        for (int[] i : set) {
            print(i);
        }

        bw.flush();
        bw.close();
    }

    static void arr(int[] result, int idx){
        if (idx == M) {
            int[] x = new int[M];
            for (int i = 0; i < M; i++) {
                x[i] = result[i];
            }
            set.add(x);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                result[idx] = arr[i];
                check[i] = true;
                arr(result, idx+1);
                check[i] = false;
            }
        }
    }
    static void print(int[] result) throws IOException {
        for (int i : result) {
            bw.write(i+" ");
        }
        bw.newLine();
    }
}