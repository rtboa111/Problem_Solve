package Problem_Solve;

import java.io.*;
import java.util.*;

public class _15666_2 {

    static int N, M;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            set.add(Integer.valueOf(st.nextToken()));
        }
        list = new ArrayList<>(set);
        Collections.sort(list);

        arr(0, 0);

        System.out.println(sb);
    }

    static void arr(int idx, int start){
        if(idx == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < list.size(); i++){
            arr[idx] = list.get(i);
            arr(idx+1, i);
        }
    }
}