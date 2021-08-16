import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[13];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        for (int j = 0; j < t; j++)
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        br.close();
    }
}
