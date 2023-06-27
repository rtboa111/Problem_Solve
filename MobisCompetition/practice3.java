package Problem_Solve.MobisCompetition;

public class practice3 {
    public int solution(String skill, String[] skill_trees) {
        boolean[] check = new boolean[26];
        for(int i = 0; i < skill.length(); i++) {
            check[skill.charAt(i)-'A'] = true;
        }
        int cnt = 0;
        for(String s : skill_trees) {
            int idx = 0;
            boolean jud = true;
            for(int i = 0; i < s.length(); i++) {
                if(check[s.charAt(i)-'A']) {
                    if(skill.charAt(idx) == s.charAt(i)) {
                        idx++;
                        continue;
                    }
                    jud = false;
                }
            }
            cnt += (jud) ? 1 : 0;
        }
        return cnt;
    }
}
