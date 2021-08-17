import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하라
N개보다 많은 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[] cost = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j + 1 > n)
                    break;
                else {
                    if (dp[i + j + 1] < dp[i] + cost[j])
                        dp[i + j + 1] = dp[i] + cost[j];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
