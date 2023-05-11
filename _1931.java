package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> meeting = new TreeMap<>();
        int[] zero = new int[N+1];
        int idx_Z = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == end) {
                zero[idx_Z++] = end;    // 시간이 안걸리는 회의
            } else {
                // 끝나는 시간이 같은 경우 시작시간이 가장 늦은 회의만 체크
                meeting.put(end, Math.max(meeting.getOrDefault(end, 0), start));
            }
        }

        if (idx_Z != 0) {
            zero[N] = Integer.MAX_VALUE;    // 끝을 최대값으로 해 비교되지 않도록 함
            Arrays.sort(zero);
        }

        int meet_end = 0;
        int count = 0;
        int idx = N - idx_Z;

        while (!meeting.isEmpty()) {
            int E = meeting.firstKey();

            if (zero[idx] < E) {
                meet_end = zero[idx++];
                count++;
            } else if (zero[idx] > E) {
                int S = meeting.remove(E);

                if (S >= meet_end) {
                    meet_end = E;
                    count++;
                }
            } else {
                int S = meeting.remove(E);

                if (S >= meet_end) {
                    meet_end = E;
                    idx++;
                    count += 2;
                } else {
                    meet_end = zero[idx++];
                    count++;
                }
            }
        }
        // 남은 시간이 안걸리는 회의 수 만큼 카운트
        count += (N - idx);
        System.out.println(count);
    }
}