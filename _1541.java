package Problem_Solve;

import java.io.*;

public class _1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] formula = br.readLine().split("-");
        int result = 0;
        for (int i = 0; i < formula.length; i++) {
            String[] formula_2 = formula[i].split("\\+");
            for (int j = 0; j < formula_2.length; j++) {
                if (i != 0) {
                    result -= Integer.parseInt(formula_2[j]);
                } else {
                    result += Integer.parseInt(formula_2[j]);
                }
            }
        }
        System.out.println(result);
    }
}