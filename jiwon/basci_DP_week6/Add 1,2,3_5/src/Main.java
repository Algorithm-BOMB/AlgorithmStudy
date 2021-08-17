import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] inputs = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }
        long[][] dp = new long[max + 3][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
        }
        for (int i = 0; i < t; i++) {
            sb.append((dp[inputs[i]][1] +
                    dp[inputs[i]][2] +
                    dp[inputs[i]][3])
                    % 1_000_000_009 + "\n");
        }
        System.out.print(sb);
        br.close();

    }
}
