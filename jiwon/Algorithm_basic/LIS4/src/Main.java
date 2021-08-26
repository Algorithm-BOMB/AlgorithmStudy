import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[n][n + 1];
        dp[0][0] = arr[0];
        dp[0][n] = 1;
        int[] res = new int[2];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            int idx = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && max < dp[j][n]) {
                    max = dp[j][n];
                    idx = j;
                }
            }
            if (max >= 0) System.arraycopy(dp[idx], 0, dp[i], 0, max);
            dp[i][max] = arr[i];
            dp[i][n] = max + 1;
            if (res[0] < dp[i][n]) {
                res[0] = dp[i][n];
                res[1] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[res[1]][i] == 0) break;
            sb.append(dp[res[1]][i]).append(" ");
        }
        System.out.println(res[0] + "\n" + sb.toString().trim());

        br.close();

    }
}
