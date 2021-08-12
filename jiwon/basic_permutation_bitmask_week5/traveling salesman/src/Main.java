/*
1 ~ n 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다.(없을 수도)
한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회여행 경로 계획

생각
- i 부터 시작해 마지막 i까지 와야한다.
- i를 먼저 v에 넣지 않은 상태에서 출발해야할 듯 하다.
- w[i][j]가 0이라면 종료
- 시작을 처음부터 0 ~ n까지 하나씩 해봐야할 듯
- 경로를 추적해야할까 ? 마지막만 알면 될 듯 ..
- 마지막에서 자기 자신으로 올 때 종료

풀이
1. depth 1부터 시작해서 dfs를 만든다. 자기 자신은 실행못하고, w[i][j] > 0만
2. dfs(depth, start, val)
3. 종료조건 depth = n일때
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int[][] w;
    static int n;
    static int end;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        v = new boolean[n];
        for (int i = 0; i < n; i++)
            w[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
        end = 0;
        dfs(1, 0, 0);
        System.out.println(result);
    }

    public static void dfs(int depth, int start, int val) {
        if (depth == n) {
            if (w[start][end] > 0) {
                val += w[start][end];
                result = Math.min(val, result);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!v[i] && w[start][i] > 0 && i != end) {
                    v[i] = true;
                    dfs(depth + 1, i, val + w[start][i]);
                    v[i] = false;
                }
            }
        }
    }
}
