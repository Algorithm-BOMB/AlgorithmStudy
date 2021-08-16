import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
x % 3 = 0 -> x // 3
x % 2 = 0 -> x // 2
else x - 1

풀이
1. 반대로 생각해서 n + 1만큼의 배열을 생성
2. 생성한 배열의 첫 번째부터 n까지 돌려서 완성 ..?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            if (i * 3 <= n && dp[i * 3] > dp[i] + 1)
                dp[i * 3] = dp[i] + 1;
            if (i * 2 <= n && dp[i * 2] > dp[i] + 1)
                dp[i * 2] = dp[i] + 1;
            if (dp[i + 1] > dp[i] + 1)
                dp[i + 1] = dp[i] + 1;
        }
        System.out.println(dp[n]);
    }
}
