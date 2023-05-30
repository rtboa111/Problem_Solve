package Problem_Solve;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {

    static int N;
    static char[][] picture;
    static Queue<coordinate> q;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    q.add(new coordinate(i, j));
                    bfs(picture[i][j]);
                    count++;
                }
            }
        }

        // 적록색맹은 R 과 G 를 구별하지 못함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'R') {
                    picture[i][j] = 'G';
                }
            }
        }
        int bCount = 0;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    q.add(new coordinate(i, j));
                    bfs(picture[i][j]);
                    bCount++;
                }
            }
        }
        System.out.println(count + " " + bCount);

    }

    static void bfs(char color) {
        Queue<coordinate> q2 = new LinkedList<>();
        while(!q.isEmpty()) {

            while(!q.isEmpty()) {
                q2.add(q.remove());
            }

            while (!q2.isEmpty()) {
                coordinate cur = q2.remove();
                if (cur.x+1 < N && picture[cur.x+1][cur.y] == color && !visit[cur.x+1][cur.y]) {
                    visit[cur.x+1][cur.y] = true;
                    q.add(new coordinate(cur.x+1, cur.y));
                }
                if (cur.x-1 >= 0 && picture[cur.x-1][cur.y] == color && !visit[cur.x-1][cur.y]) {
                    visit[cur.x-1][cur.y] = true;
                    q.add(new coordinate(cur.x-1, cur.y));
                }
                if (cur.y+1 < N && picture[cur.x][cur.y+1] == color && !visit[cur.x][cur.y+1]) {
                    visit[cur.x][cur.y+1] = true;
                    q.add(new coordinate(cur.x, cur.y+1));
                }
                if (cur.y-1 >= 0 && picture[cur.x][cur.y-1] == color && !visit[cur.x][cur.y-1]) {
                    visit[cur.x][cur.y-1] = true;
                    q.add(new coordinate(cur.x, cur.y-1));
                }
            }
        }
    }
}
class coordinate {
    int x, y;
    public coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
