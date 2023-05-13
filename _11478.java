package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11478 {

    static Set<String> subset;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        subset = new HashSet<>();
        for (int i = 1; i <= S.length(); i++) {
            put_subset(0, i);
        }
        System.out.println(subset.size());
    }
    static void put_subset(int start, int end) {
        if (end > S.length()) {
            return;
        }
        subset.add(S.substring(start, end));
        put_subset(start+1, end+1);
    }
}
