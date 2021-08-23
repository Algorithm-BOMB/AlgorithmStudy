import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] cmd = br.readLine().split("\\s");
            if (cmd[0].contentEquals("push_front"))
                deque.addFirst(cmd[1]);
            else if (cmd[0].contentEquals("push_back"))
                deque.addLast(cmd[1]);
            else if (cmd[0].contentEquals("pop_front")) {
                if (!deque.isEmpty())
                    sb.append(deque.pollFirst()).append("\n");
                else
                    sb.append("-1\n");
            } else if (cmd[0].contentEquals("pop_back")) {
                if (!deque.isEmpty())
                    sb.append(deque.pollLast()).append("\n");
                else
                    sb.append("-1\n");
            } else if (cmd[0].contentEquals("size"))
                sb.append(deque.size()).append("\n");
            else if (cmd[0].contentEquals("empty")) {
                if (!deque.isEmpty())
                    sb.append("0\n");
                else
                    sb.append("1\n");
            } else if (cmd[0].contentEquals("front")) {
                if (!deque.isEmpty())
                    sb.append(deque.peekFirst()).append("\n");
                else
                    sb.append("-1\n");
            } else if (cmd[0].contentEquals("back")) {
                if (!deque.isEmpty())
                    sb.append(deque.peekLast()).append("\n");
                else
                    sb.append("-1\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
