import java.util.*;
public class Problem1316 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int WORDCOUNT = sc.nextInt();
        sc.nextLine();

        int answer = 0;
        for (int i = 0; i < WORDCOUNT; i ++){
            String word = sc.nextLine();
            char currentChar;
            char lastChar = word.charAt(0);
            Boolean check = true;
            Map<Character,Boolean> didCharUsed = new HashMap<>();
            for(int j = 0; j<word.length(); j++){
                currentChar = word.charAt(j);
                Boolean isUsed = didCharUsed.getOrDefault(currentChar, false);
                //아닐때
                if(currentChar != lastChar && isUsed){
                    check = false;
                    break;
                }
                didCharUsed.put(currentChar, true);
                lastChar = currentChar;
                check = true;
            }
            if(check){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
