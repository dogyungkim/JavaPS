package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        var map = new HashMap<Character, Integer>();

        String s = st.nextToken().toUpperCase();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = map.values().stream().max(Integer::compareTo).get();

        List<Character> keys = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() == max){
                keys.add(entry.getKey());
            }
        }

        if (keys.size() > 1){
            System.out.println("?");
        } else {
            System.out.println(keys.get(0));
        }
    }
}
