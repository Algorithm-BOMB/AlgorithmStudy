import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int[] inputs = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= inputs[0]; i++)
            queue.add(i);
        int cnt = 0;
        while (queue.size() != 1) {
            cnt++;
            if (cnt != inputs[1])
                queue.add(queue.poll());
            else {
                sb.append(queue.poll()).append(", ");
                cnt = 0;
            }
        }
        sb.append(queue.poll());
        System.out.println("<" + sb + ">");

        br.close();
    }
}
