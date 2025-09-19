package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1.String을 하나씩 나누고 새로운 String 배열을 만든다.
        // 2.정렬 후 출력

        // 나누기
        String split = st.nextToken();
        int start = 0;
        int end = split.toCharArray().length;

        String[] arr = new String[end];
        while(start<end){
            arr[start] = split.substring(start, end);
            start++;
        }

        var sorted = new ArrayList<>(List.of(arr));
        Collections.sort(sorted);
        for(String s : sorted){
            System.out.println(s);
        }

    }
}
