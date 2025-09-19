import java.io.*;
import java.util.*;

public class Problem1300 {
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    int K = sc.nextInt();
    
  }
}


/*
 * N x N 인 배열 A
 * A[i][j] = i x j
 * 
 * 일차원 배열 B에 넣어서 오름차순 정렬
 * 이때 B[k]를 찾기
 * 
 * n <= 10^5
 * k 최대 N^2 = n ^2 이면 못품
 * 
 * 이런 형식으로
 * n = 3
 * k = 7
 * 
 * 1 2 3
 * 2 4 6
 * 3 6 9 
 */