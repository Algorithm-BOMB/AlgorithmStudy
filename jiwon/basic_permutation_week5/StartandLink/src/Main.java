/*
N은 짝수, N / 2로 이루어진 스타트 팀과 링크 팀을 나눈다.
능력치가 다르다.
비트마스크로 해결
능력치 차이가 최소로

생각
- 비트마스크의 1의 개수를 세는 함수가 있다. Integer.bitCount인듯
- 1의 개수가 N / 2여야 하고 1일 때는 스타틈, 0일 때는 링크 이런 식으로 나누면 될 듯하다.

풀이
- (1 << n)만큼 반복
- 1의 개수가 N / 2가 아니면
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int[][] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int half = n / 2;
        scores = new int[n][n];
        for (int i = 0; i < n; i++)
            scores[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> start;
        ArrayList<Integer> link;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != half)
                continue;
            start = new ArrayList<>();
            link = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    start.add(j);
                else
                    link.add(j);
            }
            int s = sumTeam(start);
            int l = sumTeam(link);
            result = Math.min(Math.abs(s - l), result);
        }
        System.out.println(result);

        br.close();

    }

    public static int sumTeam(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++)
                sum += scores[nums.get(i)][nums.get(j)]
                        + scores[nums.get(j)][nums.get(i)];
        }
        return sum;
    }
}
