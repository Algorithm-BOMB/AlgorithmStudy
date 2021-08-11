import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] nums;
    static int[] nums2;
    static boolean[] v;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        v = new boolean[n];
        nums2 = new int[n];
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            int val = 0;
            for (int i = 1; i < nums2.length; i++)
                val += Math.abs(nums2[i - 1] - nums2[i]);
            result = Math.max(val, result);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!v[i]) {
                    v[i] = true;
                    nums2[depth] = nums[i];
                    dfs(depth + 1);
                    v[i] = false;
                }
            }
        }
    }
}
