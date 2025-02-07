import java.util.*;
import java.io.*;   

public class Problem11720 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String num = sc.next();
        char[] numArray = num.toCharArray();
        int sum = 0;
        for (char c : numArray) {
            sum += c - '0';
        }
        System.out.println(sum);
        sc.close();
    }
}
