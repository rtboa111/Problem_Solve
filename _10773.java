package Problem_Solve;

import java.io.*;
/*
 * 주어지는 정수들을 더하는 문제
 * (0이 주어지면 그 전에 주어진 정수는 제외)
 *
 * 숫자 배열에 정수를 집어넣고 더함
 * 최근 숫자 배열이 들어간 index 를 기억해
 * 0이 나오면 그 index 를 제거함
 */
public class _10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        arr array = new arr(k);
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            array.put(a);
        }
        sb.append(array.sum());
        System.out.println(sb);
    }
}
class arr {
    private int[] arr;
    private int size;
    public arr(int k) {
        this.arr = new int[k];
        this.size = 0;
    }
    public void put(int a) {
        if (a!=0) {
            arr[size++] = a;
        } else {
            arr[size--] = 0;
        }
    }
    public int sum() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += arr[i];
        }
        return result;
    }
}
