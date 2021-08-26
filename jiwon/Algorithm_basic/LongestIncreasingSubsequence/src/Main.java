import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
dp는 개수가 아닌
숫자로 해야할까 ?

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] += 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
        br.close();
    }
}
