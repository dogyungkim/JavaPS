import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1920 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] A = new int[N];
    for (int i =0; i<N; i ++){
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] numsToFind = new int[M];
    for (int j = 0; j<M;j++){
      numsToFind[j] = Integer.parseInt(st.nextToken());
    }
    for(int k = 0; k<M; k++){
      int start = 0;
      int end = N - 1;
      int num = numsToFind[k];
      boolean found = false;
      while(start <= end){
        int mid = (start + end) / 2;
        if (A[mid] > num){
          end = mid - 1;
        } else if( A[mid] < num){
          start = mid + 1;
        } else {
          found = true;
          break;
        }
      }
      System.out.println(found ? 1 : 0);
    }
  }
}
