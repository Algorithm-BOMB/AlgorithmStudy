import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
모든 순열을 사전순으로 출력하는 프로그램을 작성하시오.

풀이
1. 방문했는지의 배열 하나 생성
2. 방문하지 않았으면 반복문으로 dfs 구현
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] v;
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        nums = new int[n];
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == n) {
            sb.append(Arrays.toString(nums)
                    .replaceAll("[^0-9 ]", "") + "\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (!v[i]) {
                    v[i] = true;
                    nums[depth] = i;
                    dfs(depth + 1);
                    v[i] = false;
                }
            }
        }
    }
}
