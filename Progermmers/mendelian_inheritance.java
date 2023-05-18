package Problem_Solve.Progermmers;

public class mendelian_inheritance {
    public String[] solution(int[][] queries) {

        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] info = ex(queries[i]);

            answer[i] = reference(info);
        }

        return answer;
    }
    static String reference(int[] info) {
        for(int i = 2; i < info.length; i++) {
            if(info[i] == 1) {
                return "RR";
            } else if (info[i] == 0) {
                return "rr";
            }
        }
        return "Rr";
    }

    static int[] ex(int[] temp) {
        int gen = temp[0];
        int num = temp[1];
        int[] result = new int[gen+1];
        while(gen > 1) {
            int x =  (num % 4);
            result[gen] = x;
            num /= 4;
            if(x != 0) {
                num++;
            }
            gen--;
        }
        return result;
    }
}