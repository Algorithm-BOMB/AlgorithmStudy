import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
dp[2] = 1 + 1 or cost 2
dp[3] = cost 3 or 1 + dp[2]
dp[4] = cost 4 or 1 + dp[3] or cost2 + dp[2]
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int idx = 1;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx += 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int limit = i / 2 + 1;
            dp[i] = arr[i];
            for (int j = 1; j < limit; j++) {
                dp[i] = Math.min(dp[i], arr[j] + dp[i - j]);
            }
        }
        System.out.println(dp[n]);
        br.close();
    }
}
