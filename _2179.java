package Problem_Solve;


import java.io.*;
import java.util.*;

public class _2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        HashSet<String> key = new HashSet<>();
        int max = -1;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            words.add(s);
            for (int j = 0; j <= s.length(); j++) {
                String x = s.substring(0, j);
                if (map.containsKey(x)) {
                    if (max <= j) {
                        if (max < j) {
                            key = new HashSet<>();
                            max = j;
                        }
                        key.add(x);
                        ArrayList<String> str = map.get(x);
                        if (str.size() < 2) {
                            str.add(s);
                        }
                    }
                } else {
                    ArrayList<String> str = new ArrayList<>();
                    str.add(s);
                    map.put(s.substring(0, j), str);
                }
            }
        }

        for (String i : words) {
            if (i.length() >= max && key.contains(i.substring(0, max))) {
                for (String x : map.get(i.substring(0, max))) {
                    bw.write(x);
                    bw.newLine();
                }
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}