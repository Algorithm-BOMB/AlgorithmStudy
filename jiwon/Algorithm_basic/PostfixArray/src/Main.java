import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] strings = new String[s.length()];
        for (int i = 0; i < s.length(); i++)
            strings[i] = s.substring(i);

        Arrays.sort(strings);
        for (String ss : strings)
            sb.append(ss + "\n");
        System.out.println(sb);
        br.close();

    }
}
