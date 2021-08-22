import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
dp[1][0] = 0
dp[1][1] = 1
bottom-up
dp[i][0] = dp[i - 1][1] + dp[i - 1][0]
dp[i][1] = dp[i - 1][0]
top-down -> 아직 연습이 필요
solution(a, b)
if (a == 1)
return dp[1][1]

dp[a][1] = solution(a - 1 , 0)
dp[a][0] = solution(a - 1, 1), solution(a - 1, 0)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 2][2];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println((dp[n][0] + dp[n][1]));
        br.close();
    }
}
