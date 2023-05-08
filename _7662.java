package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

/*
 * 우선순위 큐 하나로는 삭제시 시간복잡도가
 * O(N (logN)^2) 이므로 두가지 우선순위 큐와
 * HashMap 을 사용해 시간복잡도가 O (N logN) 이
 * 되도록 한다.
 */
public class _7662 {

    static Queue<Integer> ascending;
    static Queue<Integer> descending;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0 ; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            ascending = new PriorityQueue<>(k, new Comparator<Integer>() {  // 오름차순
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 < o2) {
                        return -1;
                    } else if (o1 > o2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            descending = new PriorityQueue<>(k, new Comparator<Integer>() { // 내림차순
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 > o2) {
                        return -1;
                    } else if (o1 < o2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            map = new HashMap<>(k+1);
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (order == 'I') {
                    ascending.add(n);
                    descending.add(n);
                    // getOrDefault()를 통해 n 이 이미 있을 경우 n 에대한 값만 조정한다.
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (map.size() == 0){
                    continue;
                } else {
                    mapDelete((n==1) ? descending : ascending);
                }
            }
            if (map.size() == 0) {
                bw.write("EMPTY");
            } else {
                int max = mapDelete(descending);
                // map 에 데이터가 없을 경우 max 가 마지막 데이터 였으므로 min = max
                int min = (map.size() > 0) ? mapDelete(ascending) : max;
                bw.write(max + " " + min);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int mapDelete(Queue<Integer> pq) {
        int x;
        while (true) {
            x = pq.remove();
            int count = map.getOrDefault(x, 0);

            if (count == 0) {   // 해당 값이 존재하지 않으면 다른 값에 대해 다시한다
                continue;
            }
            if (count == 1) {   // 해당 값이 하나만 존재할 경우 map 에서 삭제
                map.remove(x);
            } else {    // 해당 값이 여러개 존재할 경우 그 갯수만 줄인다.
                map.put(x, count-1);
            }
            break;
        }
        return x;
    }
}
