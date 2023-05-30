package Problem_Solve;

import java.io.*;
import java.util.*;

public class _20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        List<word> wordBook = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            if (w.length() >= M) {
                int cnt = map.getOrDefault(w, 0)+1;
                map.put(w, cnt);

            }
        }
        br.close();
        for (String w : map.keySet()) {
            int cnt = map.get(w);
            word x = new word(w, cnt);
            wordBook.add(x);
        }

        Collections.sort(wordBook);


        for (int i = 0; i < wordBook.size(); i++) {
            bw.write(wordBook.get(i).word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
class word implements Comparable<word> {
    String word;
    int count;


    public word(String w, int cnt) {
        this.word = w;
        this.count = cnt;
    }

    @Override
    public int compareTo(word o) {
        int cnt = o.count;
        String w = o.word;
        if (count == cnt) {
            if (word.length() == w.length()) {
                Comparable<String> comp = word;
                return comp.compareTo(w);
            } else {
                return w.length() - word.length();
            }
        } else {
            return cnt - count;
        }
    }
}
