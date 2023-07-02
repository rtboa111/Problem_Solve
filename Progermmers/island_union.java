package Problem_Solve.Progermmers;
import java.util.Arrays;

public class island_union {

    static int[] parents;

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        int cnt = 0, res = 0;
        for(int i = 0; i < costs.length; i++) {
            int[] cur = costs[i];
            if(find(cur[0]) != find(cur[1])) {
                union(cur[0], cur[1]);
                res += cur[2];
                cnt++;
                if(cnt == n-1) {
                    return res;
                }
            }
        }

        return res;
    }
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A > B) {
            parents[A] = B;
        } else{
            parents[B] = A;
        }
    }
    static int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return find(parents[a]);
    }
}