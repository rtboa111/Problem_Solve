package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> max_heap = new PriorityQueue<>(N, Collections.reverseOrder());
//        Collections.reverseOrder() 로 Comparator 의 compare()을 역으로 함
//        Queue<Integer> max_heap = new PriorityQueue<>(N, (o1, o2) -> {
//            return o2 - o1;
//        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            try {
                if (x == 0) {
                    bw.write(max_heap.remove()+"");
                    bw.newLine();
                } else {
                    max_heap.add(x);
                }
            } catch (NoSuchElementException e) {    // 배열에 값이 없는 경우
                bw.write(0+"");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}