package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        while ( N > 0){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String[] code = st.nextToken().split("");
            
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i<code.length; i++){
                sb.append(code[i].repeat(count));
            }

            System.out.println(sb.toString());
            N --;
        }

    }
}
