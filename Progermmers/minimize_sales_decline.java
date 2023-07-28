package Problem_Solve.Progermmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class minimize_sales_decline {

    static int[] sales;
    static int[][] dp, links;
    static ArrayList<LinkedList<Integer>> graph;

    public int solution(int[] Sales, int[][] Links) {
        int N = Sales.length;
        sales = Sales;
        links = Links;

        dp = new int[N+1][2];
        graph = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }
        for(int[] i : links) {
            graph.get(i[0]).add(i[1]);
        }

        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }
    static void dfs(int cur) {
        LinkedList<Integer> list = graph.get(cur);

        if (list.size() == 0) {
            dp[cur][1] = sales[cur-1];
            return;
        }

        int sum = 0;
        int min = (1 << 30);
        boolean flag = false;
        for(int i : list) {
            dfs(i);

            if(dp[i][0] < dp[i][1]) {
                sum += dp[i][0];
            } else {
                sum += dp[i][1];
                flag = true;
            }
            min = Math.min(min, dp[i][1] - dp[i][0]);
        }
        dp[cur][1] = sum + sales[cur-1];
        dp[cur][0] = (flag) ? sum : sum + min;
    }
}