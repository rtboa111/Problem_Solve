package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;

public class _26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String a, b;
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if(set.contains(a) || set.contains(b)) {
                set.add(a);
                set.add(b);
            }
        }
        System.out.println(set.size());
    }
}