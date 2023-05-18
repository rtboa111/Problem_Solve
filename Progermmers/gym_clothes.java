package Problem_Solve.Progermmers;

public class gym_clothes {

    public int solution(int n, int[] lost, int[] reserve) {

        int[] student = new int[n+2];

        int i = 0;
        while(i < reserve.length){
            student[reserve[i++]] = 1;
        }

        i = 0;
        while(i < lost.length){
            student[lost[i++]] += -1;
        }

        for(i = 1; i <= n; i++) {

            if(student[i] == 1) {

                if(student[i-1] == -1) {
                    student[i-1] = 0;
                } else if(student[i+1] == -1) {
                    student[i+1] = 0;
                }
            }
        }

        int answer = n;
        for(int j : student){
            if(j == -1){
                answer--;
            }
        }

        return answer;
    }
}