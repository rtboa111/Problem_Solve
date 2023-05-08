package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _11723 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        set set = new set();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String X = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            execute(X, x, set);
        }
        bw.flush();
        bw.close();
    }
    // 실행 메서드
    static void execute(String X,int x, set set) throws IOException {
        char s = X.charAt(0);
        switch (s) {
            case 'a':
                if (X.charAt(1)=='l') {
                    set.all();
                } else {
                    set.add(x);
                }
                break;
            case 'r':
                set.remove(x);
                break;
            case 'c':
                String a= set.check(x)+"";
                bw.write(a);
                bw.newLine();
                break;
            case 't':
                set.toggle(x);
                break;
            case 'e':
                set.empty();
                break;
        }
    }
}
class set {
    boolean[] check;

    public set() {
        this.check = new boolean[21];
    }
    public void add(int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
    }
    public void remove(int x) {
        if (!check[x]) {
            return;
        }
        check[x] = false;
    }
    public int check(int x) {
        if (check[x]) {
            return 1;
        }
        return 0;
    }
    public void toggle(int x) {
        if (check[x]) {
            remove(x);
            return;
        }
        add(x);
    }
    public void all() {
        for (int i = 1; i < 21; i++) {
            check[i] = true;
        }
    }
    public void empty() {
        for (int i = 1; i < 21; i++) {
            check[i] = false;
        }
    }
}
