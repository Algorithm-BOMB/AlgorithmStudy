import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
<가 나오면 그대로 출력
>가 나오고 난 뒤는 단어를 뒤집어서 출력

풀이
1. 현재 문자열이 <인지 확인
2-1. <이면 >만날 때 까지 계속 출력
2-2. <이 아니라 문자라면 stack에 담았다가 pop으로 출력

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            String c = Character.toString(s.charAt(i));
            if (c.contentEquals("<")) {
                while (!c.contentEquals(">")) {
                    c = Character.toString(s.charAt(i));
                    sb.append(c);
                    i++;
                }
                i--;
            } else {
                while (i < s.length()) {
                    c = Character.toString(s.charAt(i));
                    if (c.contentEquals(" ") || c.contentEquals("<"))
                        break;
                    stack.push(c);
                    i++;
                }
                while (!stack.isEmpty())
                    sb.append(stack.pop());
                if (c.contentEquals(" "))
                    sb.append(" ");
                else
                    i--;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
