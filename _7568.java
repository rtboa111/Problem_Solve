package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 사람들 사이의 '덩치' 비교 (키,몸무게가 모두 커야 큰것으로 간주)
 *
 * 사람 A에 대해서 사람 B가 크면
 * A의 등수를 하나씩 내렸음
 */
public class _7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parson[] group = new parson[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            group[i] = new parson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), N);
        }
        for (int i = 0; i <N; i++) {
            parson C = group[i];
            for (int j = 0; j < N; j++) {
                C.comp(group[j]);
            }
        }
        for (int i = 0; i <N; i++) {
            parson A = group[i];
            sb.append(A.rank()).append(" ");
        }
        System.out.println(sb);
    }
}
class parson {
    private int tall, weight, rank;
    public parson(int tall, int weight, int N) {
        this.tall = tall;
        this.weight = weight;
        this.rank = 1;
    }
    public int comp(parson other) {
        int diffT = tall - other.tall;
        int diffW = weight - other.weight;
        if (diffW<0 && diffT<0) {
            return rank++;
        } else {
            return rank;
        }
    }
    public int rank() {
        return rank;
    }
}
