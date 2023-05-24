package Problem_Solve.Progermmers;

public class sheet_marge {
    static String[] commands = new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
    public static void main(String[] args) {
        Solution a = new Solution();
        String[] s = a.solution(commands);
        for (String x : s) {
            System.out.println(x);
        }
    }
}
class Solution {
    static int[] sheet = new int[2501];
    static String[] sheet_val = new String[2501];

    public String[] solution(String[] commands) {

        for (int i = 1; i <= 2500; i++) {
            sheet[i] = i;
        }
        String result = "";

        for (String s : commands) {

            String[] dis = s.split(" ");

            int x = 0;
            // "UPDATE val1 val2" 형식을 제외하고 좌표값 설정
            if (dis[0].charAt(1) != 'P' || dis.length != 3) {
                x = (Integer.parseInt(dis[1]) - 1) * 50 + (Integer.parseInt(dis[2]));
            }

            switch (dis[0]) {
                case "UPDATE":
                    if (dis.length == 3) {

                        for (int i = 1 ; i <= 2500; i++) {
                            if (dis[1].equals(sheet_val[i])) {
                                sheet_val[i] = dis[2];
                            }
                        }

                    } else {

                        update(find(x), dis[3]);

                    }
                    break;

                case "MERGE":

                    int y = (Integer.parseInt(dis[3]) - 1) * 50 + (Integer.parseInt(dis[4]));
                    marge(x, y);

                    break;

                case "UNMERGE":

                    unMarge(x);
                    break;

                case "PRINT":

                    x = find(x);
                    if (sheet_val[x] == null) {
                        result += "EMPTY ";
                    } else {
                        result += sheet_val[x] + " ";
                    }
                    break;
            }
        }


        return result.split(" ");
    }
    static void update(int x, String val) {

        x = find(x);
        sheet_val[x] = val;
    }
    static void  marge(int x, int y) {
        x = find(x);
        y = find(y);

        String val = (sheet_val[x] != null) ? sheet_val[x] : sheet_val[y];

        sheet_val[x] = null;
        sheet_val[y] = null;

        union(x, y);

        sheet_val[sheet[x]] = val;
    }
    static void unMarge(int x) {
        int top = find(x);
        String val = sheet_val[top];

        for (int i = 2500; i >= 1; i--) {
            if (find(i) == top) {
                sheet[i] = i;
            }
        }

        sheet_val[top] = null;
        sheet_val[x] = val;
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            sheet[y] = x;
        } else {
            sheet[x] = y;
        }
    }
    static int find(int x) {
        if (sheet[x] != x) {
            return find(sheet[x]);
        }
        return x;
    }
}

