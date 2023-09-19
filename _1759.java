package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1759 {

    static int l, c;
    static ArrayList<char[]> ans;
    static char[] arr;
    static int[] arrC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        arrC = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            char cur = st.nextToken().charAt(0);
            arr[i] = cur;
            if (cur == 'a' || cur == 'e' || cur == 'o' || cur == 'u' || cur == 'i') {
                arrC[i] = 1;
            }
        }
        ans = new ArrayList<>();
        dfs(0, 0, new char[l]);
        ans.sort(((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] != o2[i]) return o1[i] - o2[i];
            }
            return 0;
        }));
        for (char[] i : ans) {
            bw.write(i);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int cnt, int vowel, char[] word) {
        if (cnt == l) {
            if (vowel >= 1 && vowel <= l-2) {
                ans.add(word.clone());
            }
            return;
        }
        for (int i = 0; i < c; i++) {
            if (cnt == 0 || word[cnt-1] < arr[i]) {
                word[cnt] = arr[i];
                dfs(cnt+1, vowel + arrC[i], word);
            }
        }
    }
}
