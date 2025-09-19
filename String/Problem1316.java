package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        /*
         * 어떻게 알 수 있을까 ?
         * 조건 : 문자가 연속해서 나타나는 경우
         * 즉, 전체 문자에서 한번만 나오거나, 연속해서 나올 때 
         * 연속은 무시하면되고, 전체 문자에서 한번 -> 
         * map에 넣어두고, 나왔는지 안 나왔는지 확인 : 만약 전 단어가 같은 단어면 무시
         */
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] list = st.nextToken().split("");
            String before = list[0];
            Map<String,Boolean> map = new HashMap();
            boolean isGroup = true;

            for(String s : list){
                // 나온 적이 있는지 판단
                if( map.getOrDefault(s, false)) {
                    // 만약 앞에 문자와 같은 상황이라면? 연속 된 경우임
                    if(s.equals(before)){
                        before = s;
                        continue;
                    } else {
                        // 나온적이 있고 앞에 문자랑 다르다? 연속 아님
                        isGroup = false;
                        break;
                    }

                } else {
                    // 나온 적 없음, 첫 연속
                    map.put(s, true); // 있다고 설정
                    before=s;
                }
            }
            answer = isGroup ? answer + 1: answer;
        }

        System.out.println(answer);
    }
}
