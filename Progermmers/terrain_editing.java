package Problem_Solve.Progermmers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class terrain_editing {
    static int p, q;
    public long solution(int[][] land, int P, int Q) {
        p = P; q = Q;
        int N = land.length;
        List<Long> arr = new ArrayList<>(N*N);
        for(int[] i : land) {
            for(long j : i) {
                arr.add(j);
            }
        }
        arr = arr.stream().distinct().collect(Collectors.toList());
        arr.sort(Long::compareTo);


        return binarySearch(0, arr.size()-1, land, arr);
    }
    static long binarySearch(int lo, int hi, int[][] land, List<Long> arr) {
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            long midVal1 = flattening(mid, land, arr);
            long midVal2 = flattening(mid+1, land, arr);

            if(midVal1 == midVal2) {
                break;
            }

            if(midVal1 < midVal2) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return flattening((lo + hi) / 2, land, arr);
    }
    static long flattening(int x, int[][] land, List<Long> arr) {
        long res = 0;
        long num = arr.get(x);
        for(int[] i : land) {
            for(int j : i) {
                res += (num > j) ? p * (num - j) : q * (j - num);
            }
        }
        return res;
    }
}