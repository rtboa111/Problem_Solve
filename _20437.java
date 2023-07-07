package Problem_Solve;
import java.io.*;
import java.util.ArrayList;

public class _20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            char[] string = br.readLine().toCharArray();
            int len = string.length;
            int w = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> cordi = new ArrayList<>(26);
            for(int j = 0; j < 26; j++) {
                cordi.add(new ArrayList<>(len));
            }
            for(int j = 0; j < len; j++) {
                char s = string[j];
                ArrayList<Integer> cur = cordi.get(s-'a');
                cur.add(j);
            }
            int max = -1;
            int min = (1 << 20);
            for(ArrayList<Integer> list : cordi) {
                if(list.size() >= w) {
                    int s = 0, e = w-1;
                    while(e < list.size()) {
                        max = Math.max(max, list.get(e) - list.get(s) + 1);
                        min = Math.min(min, list.get(e) - list.get(s) + 1);
                        s++; e++;
                    }
                }
            }
            if(max == -1) {
                bw.write(max+"");
            } else {
                bw.write(min + " " + max);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}