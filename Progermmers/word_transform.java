package Problem_Solve.Progermmers;

import java.util.LinkedList;
import java.util.Queue;

public class word_transform {

    static int Wlen;

    public int solution(String b, String t, String[] words) {
        int len = words.length;
        Wlen = b.length();

        boolean[] ch = new boolean[len];
        boolean jud = false;
        for(int i = 0; i < len; i++) {
            if(words[i].equals(t)) {
                ch[i] = true;
                jud = true;
            }
        }
        if(!jud) return 0;

        if(check(b, t)) {
            return 1;
        }

        Queue<String> q = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q.add(t);
        int cnt = 1;
        while(!q.isEmpty()) {
            while(!q.isEmpty()) {
                q2.add(q.remove());
            }

            while(!q2.isEmpty()) {
                String cur = q2.remove();
                for(int i = 0; i < len; i++) {
                    if(check(words[i], cur)) {
                        if(check(words[i], b)) {
                            return cnt+1;
                        }
                        q.add(words[i]);
                    }
                }
            }
            cnt++;
        }

        return 0;
    }
    static boolean check(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < Wlen; i++) {
            cnt += (a.charAt(i) == b.charAt(i)) ? 1 : 0;
        }
        return (cnt == Wlen-1);
    }
}