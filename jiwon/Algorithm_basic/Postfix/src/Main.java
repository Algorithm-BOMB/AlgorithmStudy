import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
후위표기식을 계산하라

풀이
1. 알파벳 피연산자를 스택에 넣는다.
2. 연산자가 나오면 두 개의 피연산자를 pop해 계산

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Double[] arr = new Double[n];
        Stack<Double> stack = new Stack<>();
        HashMap<String, Double> map = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < n; i++)
            arr[i] = Double.parseDouble(br.readLine());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)
                    && !map.containsKey(Character.toString(c)))
                map.put(Character.toString(c), arr[idx++]);
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                stack.push(map.get(Character.toString(s.charAt(i))));
            else {
                String op = Character.toString(s.charAt(i));
                double result = 0;
                double a = stack.pop();
                double b = stack.pop();
                if (op.contentEquals("+"))
                    result += a + b;
                else if (op.contentEquals("-"))
                    result += b - a;
                else if (op.contentEquals("*"))
                    result += a * b;
                else if (op.contentEquals("/"))
                    result += b / a;
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}
