package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        known = new boolean[N];
        knownP = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int cur = Integer.parseInt(st.nextToken())-1;
            knownP.add(cur);
            known[cur] = true;
        }

        people = new ArrayList<>();
        partyJoin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            people.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            partyJoin.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken())-1;
                people.get(cur).add(i);
                partyJoin.get(i).add(cur);
            }
        }

        bfs();

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (!checkParty[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static ArrayList<ArrayList<Integer>> people, partyJoin;
    static ArrayList<Integer> knownP;
    static boolean[] checkParty, known;
    static int N, M;
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        checkParty = new boolean[M];

        for (int i : knownP) {
            ArrayList<Integer> cur = people.get(i);
            for (int j : cur) {
                if (!checkParty[j]) {
                    checkParty[j] = true;
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int curParty = q.remove();

            ArrayList<Integer> curPartyJoin = partyJoin.get(curParty);

            for (int i : curPartyJoin) {
                if (!known[i]) {
                    known[i] = true;
                    knownP.add(i);

                    ArrayList<Integer> curPersonJoinParty = people.get(i);

                    for (int j : curPersonJoinParty) {
                        if (!checkParty[j]) {
                            checkParty[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
    }
}