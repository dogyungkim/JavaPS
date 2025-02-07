import java.util.Scanner;
import java.util.*;

public class Problem1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] score = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(score).max().getAsInt();
        double total = 0;
        for (int s : score) {
            total += s;
        }
        System.out.println(total / max * 100 / N);
        sc.close();
    }
}

