/*
n개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의
원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성

생각
- 어떻게 비트마스크로 풀지..
- DFS는 써야할 것 같음
- 방문했는지의 여부를 비트마스크로 하면 되나?
- 일단 방문했는지의 여부를 비트마스크로 해보자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(("\\s"));
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        if (s == 0)
            cnt -= 1;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) != 0)
                    sum += arr[j];
            if (sum == s)
                cnt += 1;
        }
        System.out.println(cnt);
        br.close();
    }


}
