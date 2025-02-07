import java.util.Scanner;

public class Problem2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        int count = 1;
        int start = 1;
        int end = 1;
        while(end != N){
            if (sum < N) {
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            } else {
                end++;
                sum = sum + end;
                count ++;
            }
        }
        System.out.println(count);
    }
}
