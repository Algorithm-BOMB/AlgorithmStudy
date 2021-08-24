import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수를 의미

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        n = 0;
        while (st.hasMoreTokens())
            arr[n++] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                answer[idx] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
            answer[stack.pop()] = -1;
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();

    }
}
