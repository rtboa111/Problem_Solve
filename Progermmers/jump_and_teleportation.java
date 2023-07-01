package Problem_Solve.Progermmers;

public class jump_and_teleportation {
    public int solution(int n) {

        int res = 0;
        while(n != 0) {
            res += n % 2;
            n /= 2;
        }
        return res;
    }
}