package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _7569 {

    static boolean[][][] check;
    static int N,M,H,count;
    static int[][][] box;
    static Queue<int[]> q = new LinkedList<int[]>();
    static Queue<int[]> q2 = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        check = new boolean[H][N][M];

        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if (box[k][i][j] == 1) {
                        int[] coordinate = new int[]{k, i, j};
                        q.add(coordinate);      // queue 목록에 정점 추가
                        check[k][i][j] = true;  // queue 목록에 올라간 정점 체크
                    }
                    else if(box[k][i][j] == -1) {
                        check[k][i][j] = true;
                    }
                }
            }
        }

        count = 0;
        while(q.peek()!=null) {
            while(q.peek()!=null){
                q2.add(q.poll());
            }
            count++;    // 한번 탐색할 때마다 날짜 카운트

            while(q2.peek()!=null){
                bfs(q2.poll());
            }
        }
        count--;    // 탐색 시작 날 카운트 제거


        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if (!check[k][i][j]) {
                        count = -1;
                    }   // 안 익은 토마토가 있으면 -1로
                }
            }
        }
        System.out.println(count);
    }


    static void bfs(int[] c) {
        if(box[c[0]][c[1]][c[2]] == 0) {
            box[c[0]][c[1]][c[2]] = 1;
        }
        // 익은 토마토 주위에 있는 토마토가 익지 않은 토마토면 queue 에 추가 하고 체크
        if(c[0]+1 < H && box[c[0]+1][c[1]][c[2]] == 0 && !check[c[0]+1][c[1]][c[2]]) {
            q.add(new int[]{c[0]+1, c[1], c[2]});
            check[c[0]+1][c[1]][c[2]] = true;
        }
        if(c[1]+1 < N && box[c[0]][c[1]+1][c[2]] == 0 && !check[c[0]][c[1]+1][c[2]]) {
            q.add(new int[]{c[0], c[1]+1, c[2]});
            check[c[0]][c[1]+1][c[2]] = true;
        }
        if(c[2]+1 < M && box[c[0]][c[1]][c[2]+1] == 0 && !check[c[0]][c[1]][c[2]+1]) {
            q.add(new int[]{c[0], c[1], c[2]+1});
            check[c[0]][c[1]][c[2]+1] = true;
        }
        if(c[0]-1 >= 0 && box[c[0]-1][c[1]][c[2]] == 0 && !check[c[0]-1][c[1]][c[2]]) {
            q.add(new int[]{c[0]-1, c[1], c[2]});
            check[c[0]-1][c[1]][c[2]] = true;
        }
        if(c[1]-1 >= 0 && box[c[0]][c[1]-1][c[2]] == 0 && !check[c[0]][c[1]-1][c[2]]) {
            q.add(new int[]{c[0], c[1]-1, c[2]});
            check[c[0]][c[1]-1][c[2]] = true;
        }
        if(c[2]-1 >= 0 && box[c[0]][c[1]][c[2]-1] == 0 && !check[c[0]][c[1]][c[2]-1]) {
            q.add(new int[]{c[0], c[1], c[2]-1});
            check[c[0]][c[1]][c[2]-1] = true;
        }
    }
}