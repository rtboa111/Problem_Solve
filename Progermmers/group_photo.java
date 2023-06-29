package Problem_Solve.Progermmers;

public class group_photo {
    static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] check;
    static String[] d;

    public int solution(int n, String[] data) {
        d = new String[n];
        for(int i = 0; i < n; i++) {
            d[i] = data[i];
        }
        check = new boolean[8];
        cnt = 0;
        dfs(new String(""));
        return cnt;
    }
    static int cnt;
    static void dfs(String cur) {
        if(cur.length() == 8) {
            cnt++;
            return;
        }

        for(int i = 0; i < 8; i++) {
            if(!check[i] && condition(cur, i)) {
                check[i] = true;
                dfs(cur + friend[i]);
                check[i] = false;
            }
        }
    }

    static boolean condition(String cur, int idx) {
        int size = cur.length();
        for(String s : d) {
            if(s.charAt(0) == friend[idx]) {
                int num = -1;
                for(int i = 0; i < size; i++) {
                    if(s.charAt(2) == cur.charAt(i)) {
                        num = i;
                        break;
                    }
                }
                if(++num > 0) {
                    if(s.charAt(3) == '=') {
                        if(size - num + '0' != s.charAt(4)) {
                            return false;
                        }
                    } else if(s.charAt(3) == '>') {
                        if(size - num + '0' <= s.charAt(4)) {
                            return false;
                        }
                    } else if(s.charAt(3) == '<') {
                        if(size - num + '0' >= s.charAt(4)) {
                            return false;
                        }
                    }
                }
            }

            if (s.charAt(2) == friend[idx]) {
                int num = -1;
                for(int i = 0; i < size; i++) {
                    if(s.charAt(0) == cur.charAt(i)) {
                        num = i;
                        break;
                    }
                }
                if(++num > 0) {
                    if(s.charAt(3) == '=') {
                        if(size - num + '0' != s.charAt(4)) {
                            return false;
                        }
                    } else if(s.charAt(3) == '>') {
                        if(size - num + '0' <= s.charAt(4)) {
                            return false;
                        }
                    } else if(s.charAt(3) == '<') {
                        if(size - num + '0' >= s.charAt(4)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}