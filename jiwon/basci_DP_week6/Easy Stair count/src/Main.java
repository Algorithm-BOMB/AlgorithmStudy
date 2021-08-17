import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
계단 수는 차이가 1씩 나는 것
N이 1일 때는 무조건 9인듯
N = 2
12 10
21 23
32 34
43 45
54 56
dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        for (int i = 1; i < 10; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % 1_000_000_000;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1_000_000_000;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 1_000_000_000;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % 1_000_000_000;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5]) % 1_000_000_000;
            dp[i][5] = (dp[i - 1][4] + dp[i - 1][6]) % 1_000_000_000;
            dp[i][6] = (dp[i - 1][5] + dp[i - 1][7]) % 1_000_000_000;
            dp[i][7] = (dp[i - 1][6] + dp[i - 1][8]) % 1_000_000_000;
            dp[i][8] = (dp[i - 1][7] + dp[i - 1][9]) % 1_000_000_000;
            dp[i][9] = dp[i - 1][8] % 1_000_000_000;
        }
        long res = 0;
        for(int i = 0; i < 10; i++)
            res += dp[n][i];
        System.out.println(res % 1_000_000_000 );
        br.close();
    }
}
