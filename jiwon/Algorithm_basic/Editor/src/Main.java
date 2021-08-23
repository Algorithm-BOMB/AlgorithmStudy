import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
L 이면 stack pop, temp push
R 이면 stack push, temp pop

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Stack<String> temp = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++)
            stack.push(Character.toString(s.charAt(i)));
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] cmd = br.readLine().split("\\s");
            if (cmd[0].contentEquals("L") && !stack.isEmpty())
                temp.push(stack.pop());
            else if (cmd[0].contentEquals("D") && !temp.isEmpty())
                stack.push(temp.pop());
            else if (cmd[0].contentEquals("P"))
                stack.push(cmd[1]);
            else if (cmd[0].contentEquals("B") && !stack.isEmpty())
                stack.pop();
        }
        while (!stack.isEmpty())
            temp.push(stack.pop());
        while (!temp.isEmpty())
            sb.append(temp.pop());
        System.out.println(sb);
        br.close();

    }
}
