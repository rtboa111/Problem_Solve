package Problem_Solve.Progermmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;


public class bad_user {

    static ArrayList<boolean[]> list;
    static HashSet<String> set;
    static boolean[] used, usedB;
    static int uN, bN;

    public int solution(String[] user_id, String[] banned_id) {
        uN = user_id.length;
        bN = banned_id.length;
        list = new ArrayList<>(bN);
        for(int i = 0; i < bN; i++) {
            boolean[] check = new boolean[uN];
            String cur = banned_id[i];
            for(int j = 0; j < uN; j++) {
                String uCur = user_id[j];
                if(uCur.length() != cur.length()) {
                    continue;
                }
                int b = 0, u = 0;
                while(b < cur.length() &&
                        (cur.charAt(b) == uCur.charAt(u) || cur.charAt(b) == '*')) {
                    b++; u++;
                }
                check[j] = (b == cur.length());
            }
            list.add(check);
        }

        set = new HashSet<>();
        used = new boolean[uN];
        usedB = new boolean[bN];
        backtracking(0, 0, new int[bN]);

        return set.size();
    }
    static void backtracking(int cnt, int start, int[] cur)  {
        if(cnt == bN) {
            int[] tmp = new int[bN];
            int idx = 0;
            for(int i : cur) {
                tmp[idx++] = i;
            }
            Arrays.sort(tmp);
            String s = "";
            for(int i : tmp) {
                s += String.valueOf(i);
            }
            set.add(s);

            return;
        }

        for(int i = start; i < uN; i++) {
            for(int j = 0; j < bN; j++) {
                if(!usedB[j] && list.get(j)[i] && !used[i]) {
                    used[i] = true;
                    usedB[j] = true;
                    cur[j] = i;
                    backtracking(cnt + 1, i + 1, cur);
                    used[i] = false;
                    usedB[j] = false;
                }
            }
        }
    }
}