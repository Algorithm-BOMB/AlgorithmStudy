import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제====
자연수 n은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있음
주어진 자연수 N을 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성

생각====
항의 개수가 최소가 되어야하므로 가장 근접한 큰 수를 구하고 나머지를 구하는 방식으로 ??
N의 제곱근을 구하고 N의 제곱근보다 낮은 순서부터해서 구하는 방식을 사용해야할 듯..?
7 = 2^2 + 1^2 + 1^2 + 1^2

어떻게 DP를 적용할 수 있을까?
1, 2, 3, 4, 5, 6, 7
0  0  0  1  2  3  4
11일 때
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
0, 0, 0, 1, 0, 0, 0, 2, 1, 2,  3


풀이
1. n의 제곱근 구하기
2. n의 제곱근부터 시작 ~ 1까지 i
3. 2중 반복문에서는 i부터 시작해 num이 제곱근보다 작을 때는 작은 제곱근으로 변경
4. dp[n]

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine());
        for (int n = 1; n < 100001; n++) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
            int[] dp2 = new int[n + 1];
            Arrays.fill(dp2, 1000);
            int n2 = (int) Math.sqrt(n);
            int[] arr = new int[n2 + 1];
            for (int i = 1; i <= n2; i++)
                arr[i] = i * i;
            for (int i = n2; i > 0; i--) {
                int val = arr[i];
                int a = i;
                int cnt = 1;
                while (val != n) {
                    if (val + arr[a] > n && a > 1)
                        a--;
                    else if (val + arr[a] <= n) {
                        val += arr[a];
                        cnt++;
                        dp2[val] = Math.min(cnt, dp2[val]);
                    }
                }
                dp2[val] = Math.min(cnt, dp2[val]);
            }


            if (dp[n] != dp2[n]) {
                System.out.println("dp[" + n + "] = " + dp[n]);
                System.out.println("dp2[" + n + "] = " + dp2[n]);
            }
        }



        br.close();

    }
}
