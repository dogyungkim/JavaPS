import java.util.*;

public class Problem12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Set up
        int DNA_LENGTH = sc.nextInt()-1 ;
        int PWD_LENGTH = sc.nextInt()-1;
        sc.nextLine();

        char[] dnaString = sc.nextLine().toCharArray();
        char[] dnaChar = {'A','C','G','T'};

        // 필요 문자열의 수 저장
        Map<Character,Integer> charNeeded = new HashMap<>();
        for (char c : dnaChar){
            charNeeded.put(c, sc.nextInt());
        }


        int start = 0;
        int end = PWD_LENGTH;
        int count = 0;
        Map<Character,Integer> charCount = new HashMap<>();

        // 첫 슬라이스 정보 저장
        char[] slicedString = Arrays.copyOfRange(dnaString, start, end+1);
        for(char c : slicedString){
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }
        int checker = 0;
        for(char dna : dnaChar){
            if(charNeeded.get(dna) <= charCount.getOrDefault(dna,0)){
                checker++;
            }
        }
        if (checker == 4){
            count ++;
        }

        for(int i = 0; i<DNA_LENGTH - PWD_LENGTH; i++){
            charCount.put(dnaString[start], charCount.get(dnaString[start]) - 1);
            start++;
            end++;
            charCount.put(dnaString[end], charCount.getOrDefault(dnaString[end],0) + 1);

            checker = 0;
            for(char dna : dnaChar){
                if(charNeeded.get(dna) <= charCount.getOrDefault(dna,0)){
                    checker++;
                }
            }
            if (checker == 4){
                count ++;
            }
        }
        
        System.out.println(count);
    }
}
