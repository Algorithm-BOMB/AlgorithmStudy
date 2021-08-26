import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
문제===
연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰합을 구하려고 한다.
단, 수는 한 개 이상 선택.

생각===
왼쪽의 전체 합계 sumL
오른쪽의 전체 합계 sumR
i가 하나씩 지나갈 때 마다 왼쪽 합계는 +, 오른쪽은 -
왼쪽 합계, 합계가

풀이===
1. 0 ~ n까지 반복하면서 왼쪽 합계를 구한다.
2. 왼쪽 합계가 최대가 될 수 있도록, -인 경우 +가 나왔을 때 변경
3. -인 경우 -가 나왔을 때는 자기 자신
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] < 0)
                dp[i] = arr[i];
            else
                dp[i] = dp[i - 1] +  arr[i];
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
        br.close();
    }
}
