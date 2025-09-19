import java.io.*;
import java.util.*;

public class Problem2343 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] lectures = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i<N; i++){
      lectures[i] = Integer.parseInt(st.nextToken());
    }
    // 순서대로 강의가 들어가야함
    int min = Arrays.stream(lectures).max().getAsInt();
    int max = Arrays.stream(lectures).sum();
    while (min <= max){
      int mid = (min + max) / 2;
      int count = 0;
      int sum = 0;
      for(int i = 0; i<N; i++){
        if(sum + lectures[i] > mid){
          count ++;
          sum =0;
        }
        sum += lectures[i];
      }
      if (sum != 0){
        count ++;
      }
      if(count > M){
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    System.out.println(min);
  }
}
/*
 * 블루레이에 N개의 강의가 순서대로 들어가야함
 * 블루에이의 개수를 줄이려고 함
 * M개의 블루레이에 모든 동영상 녹화 -> 블루레이 크기를 최소화 하려고 한다. M개의 블루레이는 모두 같은 크기여야한다.
 * 
 * 강의의 길이가 분 단위로(int) 로 주어진다.
 * 각 강의의 길이는 10,000 을 넘지 않음
 * 
 * 1<= N <= 100,000
 * 1 <= M <= N
 * 
 * 입력
 * 첫재줄 : N(강의 수), M(블루레이 갯수)
 * 둘째줄 : 강의 순서
 */