import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] cmd = br.readLine().split("\\s");
            if (cmd[0].contentEquals("push"))
                queue.addLast(cmd[1]);
            else if (cmd[0].contentEquals("pop")) {
                if (!queue.isEmpty())
                    sb.append(queue.pollFirst()).append("\n");
                else
                    sb.append("-1\n");
            } else if (cmd[0].contentEquals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (cmd[0].contentEquals("empty")) {
                if (queue.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            } else if (cmd[0].contentEquals("front")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.peek()).append("\n");
            } else if (cmd[0].contentEquals("back")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.peekLast()).append("\n");
            }
        }
        System.out.print(sb);

        br.close();

    }
}
