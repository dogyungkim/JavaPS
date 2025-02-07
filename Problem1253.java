import java.util.Scanner;
import java.util.*;
public class Problem1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        long[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        int count = 0;

        for(int i=0; i<N; i++){
            int start = 0;
            int end = N - 1;
            long sum = 0;

            while(end > start){
                sum = arr[start] + arr[end];
                if (sum == arr[i]){
                    if( start != i && end != i){
                        count ++;
                        break;
                    } else if (start == i){
                        start ++;
                    } else if (end == i){
                        end --;
                    }
                }
                if (sum > arr[i]) {
                    end --;
                } else if (sum < arr[i]) {
                    start ++;
                }
            }
        }
        System.out.println(count);
    }
}
