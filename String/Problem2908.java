package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String first = new StringBuilder(st.nextToken()).reverse().toString();
        String second = new StringBuilder(st.nextToken()).reverse().toString();

        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);

        System.out.println(a > b ? a : b);
        
    }
}
