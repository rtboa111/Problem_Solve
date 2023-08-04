package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _25280 {

    static int n;
    static final double add = 1D / (1 << 20);
    static ArrayList<double[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(n);
        double minB = 1 << 20;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            arr.add(new double[]{a, b});
            minB = Math.min(minB, b);
        }

        System.out.println(binarySearch(0, minB));

    }
    static double binarySearch(double lo, double hi) {

        while (lo <= hi) {
            double mid = (lo + hi) / 2;
            double target = execute(mid);

            if (target > 0.5) {
                lo = mid + add;
            } else if (target < 0.5){
                hi = mid - add;
            } else {
                return mid;
            }
        }

        return (lo + hi) / 2;
    }
    static double execute(double mid) {
        double ans = 1;
        for (double[] i : arr) {
            ans *= Math.min(1, (i[1] - mid) / (i[1] - i[0]));
        }
        return ans;
    }
}