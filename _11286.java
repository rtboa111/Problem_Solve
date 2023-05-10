package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> heap_absolute = new PriorityQueue<>((o1, o2) -> {
                if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else {
                    if (o1 < o2) return -1;
                }
                return 1;
        });
//        Queue<Integer> heap_absolute = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (Math.abs(o1) < Math.abs(o2)) {
//                    return -1;
//                } else if (Math.abs(o1) > Math.abs(o2)) {
//                    return 1;
//                } else {
//                    if (o1 < o2) return -1;
//                }
//                return 1;
//            }
//        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                heap_absolute.add(x);
            } else {
                if (heap_absolute.isEmpty()) {
                    bw.write(0+"");
                } else {
                    bw.write(heap_absolute.remove()+"");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}