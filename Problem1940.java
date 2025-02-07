import java.util.Arrays;
import java.util.Scanner;

public class Problem1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int last = N - 1;
        Arrays.sort(arr);
        int count = 0;
        while (last > start){
            int sum = arr[start] + arr[last];
            if (sum < M){
                start ++;
            } else if(sum > M){
                last--;
            } else {
                start ++;
                last --;
                count ++;
            }
        }
        System.out.println(count);
    }
}
