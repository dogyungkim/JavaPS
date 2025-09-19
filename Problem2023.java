import java.util.*;

public class Problem2023 {
  static StringBuffer sb = new StringBuffer();
  static int[] intArr = {1,3,5,7,9};
  static int N;
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int[] oneDigitSosu = {2,3,5,7};
    for(int i : oneDigitSosu){
      DFS(i);
    }
    System.out.println(sb.toString());
  }
  public static void DFS(int num){
    // 소수 확인
    if(String.valueOf(num).length() == N){
      if (isPrime(num)){
        sb.append(num).append("\n");
      }
      return;
    }
    for(int n : intArr){
      if (isPrime(num)){
        DFS(num * 10 + n);
      }
    }
  }

  public static boolean isPrime(int num){
    if (num <= 1) return false;
    for (int i = 2; i<= Math.sqrt(num); i++){
      if (num % i == 0) return false;
    }
    return true;
  }
}
