import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[] answer = next_permutation(nums);
        if (answer == null)
            System.out.println("-1");
        else
            System.out.println(Arrays.toString(answer).
                    replaceAll("[^0-9 ]", ""));
        br.close();

    }

    public static int[] next_permutation(int[] nums) {
        int idx = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return null;
        for (int k = nums.length - 1; k > 0; k--) {
            if (nums[idx - 1] < nums[k]) {
                int temp = nums[idx - 1];
                nums[idx - 1] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        int[] aa = Arrays.copyOfRange(nums, idx, nums.length);
        Arrays.sort(aa);
        int[] ans = new int[nums.length];
        System.arraycopy(nums, 0, ans, 0, idx);
        System.arraycopy(aa, 0, ans, idx, aa.length);
        return ans;
    }
}
