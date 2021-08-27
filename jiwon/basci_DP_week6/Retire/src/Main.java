import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
얻을 수 있는 최대 수익을 구하는 프로그램을 구하시오.

생각=====
DP는 점화식 구하기
pt
i = 1 ~ n까지
if i + pt[j][0] <= n + 1
dp[i] = max(dp[i], dp[i + pt[j][0]] + pt[j][1])


 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pt = new int[n + 1][2];
        int[] dp = new int[n + 2];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("\\s");
            pt[i][0] = Integer.parseInt(s[0]);
            pt[i][1] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= n; i++) {
            if (i + pt[i][0] <= n + 1)
                dp[i + pt[i][0]] = Math.max(dp[i + pt[i][0]], dp[i] + pt[i][1]);
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        for (int i : dp)
            max = Math.max(max, i);

        System.out.println(max);

        br.close();

    }
}
