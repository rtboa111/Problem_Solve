package Problem_Solve.Progermmers;

public class life_boat {
    public int solution(int[] people, int limit) {
        int[] weight = new int[241];
        // 무게별 사람들 수 조사
        for(int i = 0; i < people.length; i++) {
            weight[people[i]]++;
        }

        int answer = 0;
        for(int i = 40; i <= 240; i++) {
            while(weight[i] > 0) {

                int boat = limit - i; // 보트에 태움
                weight[i]--;

                int j = 0;
                // 보트에 자리가 없을 때 까지
                while(boat - j >= 40) {
                    if(boat - j > 240) {
                        j += boat - j - 240;
                    }

                    // 원하는 무게의 사람이 있을 때
                    if(weight[boat - j] > 0) {
                        weight[boat - j]--;
                        boat -= (boat - j);
                        j = 0;
                    } else {
                        j++;
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}