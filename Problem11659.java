import java.util.Scanner;
import java.util.*;

public class Problem11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NUMCOUNT = sc.nextInt();
        int CALCOUNT = sc.nextInt();
        sc.nextLine();

        int[] sums = new int[NUMCOUNT + 1];
        for(int i = 1; i <= NUMCOUNT; i ++){
            sums[i] = sums[i - 1] + sc.nextInt();
        }
        sc.nextLine();
        for(int j = 0; j < CALCOUNT; j++){
            int[] range = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(sums[range[1]] - sums[range[0]-1]);
        }
    }
}
