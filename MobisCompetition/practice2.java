package Problem_Solve.MobisCompetition;

public class practice2 {

    static int[] prefixSum;
    static int size;

     public int solution(int[] cookie) {
        size = cookie.length;
        prefixSum = new int[size+1];
        for(int i = 1; i <= size; i++) {
            prefixSum[i] += prefixSum[i-1] + cookie[i-1];
        }
        return divideConquer(size/2, 0, size);
    }

    static int divideConquer(int m, int l, int r) {
        if(m <= l || m >= r) {
            return 0;
        }
        int lMax = divideConquer((m+l)/2, l, m);
        int rMax = divideConquer((r+m)/2, m, r);
        int curMax = execute(m);
        return Math.max(lMax, Math.max(rMax, curMax));
    }
    static int execute(int m) {
        int l = m-1, r = m+1;
        if(l < 0 || r > size) {
            return 0;
        }
        int lSum, rSum;
        int res = 0;
        while(l >= 0 && r <= size) {
            lSum = prefixSum[m] - prefixSum[l];
            rSum = prefixSum[r] - prefixSum[m];
            if(lSum > rSum) {
                r++;
            } else if(lSum < rSum) {
                l--;
            } else {
                res = Math.max(res, lSum);
                r++; l--;
            }
        }
        return res;
    }
}