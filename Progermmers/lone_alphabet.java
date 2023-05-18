package Problem_Solve.Progermmers;

public class lone_alphabet {
    public String solution(String input_string) {
        boolean[] check = new boolean[26];
        boolean[] S = new boolean[26];
        int j = 0;
        for(int i = 0; i < input_string.length()-1; i++) {
            char s = input_string.charAt(i);
            if(check[s-'a']) {
                S[s-'a'] = true;
            }
            if(s != input_string.charAt(i+1)) {
                check[s-'a'] = true;
            }
        }
        char temp = input_string.charAt(input_string.length()-1);
        if(check[temp-'a']) {
            S[temp -'a'] = true;
        }

        String answer = "";
        char[] s = new char[26];
        boolean t = false;
        for(int i = 0; i < 26; i++) {
            if(S[i]) {
                s[i] = (char) (i+'a');
                t = true;
            }
        }
        if (!t) {
            return "N";
        }
        for(int i = 0; i < 26; i++) {
            if(s[i] > 'a'-1){
                answer += Character.toString(s[i]);
            }
        }
        return answer;
    }
}