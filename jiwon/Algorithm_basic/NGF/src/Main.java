
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
등장한 횟수..

생각
- 등장했을 때 마다 stack에 넣기 ?
-
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[n];
        int[] arr = new int[n];
        n = 0;
        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            arr[n++] = val;
            map.put(arr[n - 1], map.getOrDefault(arr[n - 1], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                    map.get(arr[stack.peek()]) < map.get(arr[i]))
                answer[stack.pop()] = arr[i];
            stack.push(i);
        }
        while (!stack.isEmpty())
            answer[stack.pop()] = -1;

        for (int num : answer)
            sb.append(num).append(" ");
        System.out.println(sb.toString().trim());
        br.close();

    }
}
