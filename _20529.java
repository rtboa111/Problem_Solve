package Problem_Solve;

import java.io.*;
import java.util.*;

public class _20529 {

    static List<char[]> list = new ArrayList<>();
    static char[][] myMBTI = new char[][]{{'I', 'N', 'T', 'P'},{'E', 'S', 'F', 'J'}};
    static int[][] memory;
    static int[] arr;
    static boolean[] check;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        check = new boolean[4]; // MBTI 픽 체크
        memory = new int[16][16];   // MBTI 들 간의 심리거리 메모리
        pickMBTI(0, new int[4]);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                memory[i][j] = diff(list.get(i), list.get(j));
            }
        }

        String[] index = new String[16]; // MBTI index 저장
        for (int i = 0; i < 16; i++) {
            index[i] = "";
            for (int j = 0; j < 4; j++) {
                index[i] += list.get(i)[j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[16];
            check = new boolean[16];
            count = 16;
            StringTokenizer st = new StringTokenizer(br.readLine());
            loop:
            for (int j = 0; j < N; j++) {
                String s = st.nextToken();
                for (int k = 0; k < 16; k++) {
                    if (arr[k] < 3 && index[k].equals(s)) {
                        arr[k]++;
                        break;
                    } else if (arr[k] == 3) break loop; // 3명이 같은 MBTI면 종료
                }
            }

            for (int j = 0; j < 16; j++) {
                if (arr[j] > 0) {
                    check[j] = true;
                }
            }

            choiceStudent(0, new int[3]);

            bw.write(count+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    // 3명의 MBTI 거리의 합 / backtracking
    static void choiceStudent(int idx, int[] res) {
        if (idx == 3) {
            int cur = memory[res[0]][res[1]] + memory[res[0]][res[2]] + memory[res[1]][res[2]];
            count = Math.min(count, cur);
            return;
        }

        for (int i = 0; i < 16; i++) {
            if (check[i] && arr[i] > 0 && res[Math.max(idx-1, 0)] <= i) {
                arr[i]--;
                res[idx] = i;
                choiceStudent(idx+1, res);
                arr[i]++;
            }
        }
    }
    // 각 척도별로 한가지씩 선택해서 해당 MBTI에 번호 부여 / backtracking
    static void pickMBTI(int idx, int[] arr) {
        if (idx == 4) {
            createMBTI(arr);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            if (!check[idx]) {
                check[idx] = true;
                arr[idx] = i%2;
                pickMBTI(idx+1, arr);
                check[idx] = false;
            }
        }
    }
    // MBTI 끼리의 심리거리 구하기
    static int diff(char[] a, char[] b) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) {
                cnt++;
            }
        }
        return cnt;
    }
    // MBTI 에 번호 부여
    static int createMBTI(int[] arr) {
        int cnt = 0;
        char[] mbti = new char[4];
        for (int i = 0; i < 4; i++) {
            if (arr[i] == 0) {
                mbti[i] = myMBTI[0][i];
            } else {
                mbti[i] = myMBTI[1][i];
            }
        }
        list.add(mbti);
        return cnt;
    }
}