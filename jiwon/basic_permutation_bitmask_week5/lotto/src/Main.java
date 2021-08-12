/*
조합을 구하는 문제 오름차순으로 주어지므로, 정렬은 하지 않아도 된다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] v;
    static final int END = 6;
    static int[] nums = new int[END];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.contentEquals("0"))
                break;
            int[] arr = Arrays.stream(s.split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
            v = new boolean[arr[0] + 1];
            dfs(0, 1, arr);
            sb.append("\n");
        }

        System.out.print(sb.toString().trim());

        br.close();
    }

    public static void dfs(int depth, int idx, int[] arr) {
        if (depth == END) {
            sb.append(Arrays.toString(nums).replaceAll("[^0-9 ]", ""))
                    .append("\n");
        } else {
            for (int i = idx ; i <= arr[0]; i++) {
                if (!v[i]) {
                    v[i] = true;
                    nums[depth] = arr[i];
                    dfs(depth + 1, i, arr);
                    v[i] = false;
                }
            }
        }
    }
}
