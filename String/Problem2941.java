package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        // 기존 알파벳 + 코리아티아 대치 글자가 섞여있다.
        // 크로아티아 알파벳
        List<String> croatianAlphabet = List.of(new String[]{"c=", "c-","dz=","d-","lj","nj","s=","z="});

        String[] list = st.nextToken().split("");

        int max = list.length - 1;
        for (int i = 0; i<list.length; i++){
            String now = list[i];
            String next = list[Math.min(i + 1, max)];
            if (croatianAlphabet.contains(now + next)){
                if(now.equals("d") && next.equals("z") && i + 2 <= max && list[i + 2].equals("=")){
                    i ++;
                }
                i ++;
            }
            answer++;
        }
        
        // 두 글자씩 자르기
        System.out.println(answer);
    }
}
