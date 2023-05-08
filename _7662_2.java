package Problem_Solve;

import java.io.*;
import java.util.*;
/*
 * 이진트리 형태의 TreeMap 을 통해
 * firstKey 와 lastKey 를 얻는 것으로
 * 최소, 최대 값을 빠르게 찾을 수 있음.
 * 시간복잡도는 O(logN) - 원하는 값 삭제 시
 */
public class _7662_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, Integer> ascending;
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            ascending = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                char s = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (s == 'I') {
                    ascending.put(n, ascending.getOrDefault(n,0) + 1);
                } else if (ascending.isEmpty()) {
                    continue;
                } else {
                    if (n == -1) {
                        int key = ascending.firstKey();
                        int val = ascending.get(key);
                        if (val == 1) {
                            ascending.remove(key);
                        } else {
                            ascending.put(key, val - 1);
                        }
                    } else {
                        int key = ascending.lastKey();
                        int val = ascending.get(key);
                        if (val == 1) {
                            ascending.remove(key);
                        } else {
                            ascending.put(key, val -1);
                        }
                    }
                }
            }
            if (ascending.isEmpty()) {
                bw.write("EMPTY");
            } else {
                int min = ascending.firstKey();
                int max = ascending.lastKey();
                bw.write(max + " " + min);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}