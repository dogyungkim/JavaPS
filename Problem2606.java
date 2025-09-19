import java.util.*;
import java.io.*;

public class Problem2606 {
  static int N, M, count;
  static ArrayList<Integer>[] arr;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    arr = new ArrayList[N+1];
    visited = new boolean[N+1];

    for (int i=0;i<=N;i++){
      arr[i] = new ArrayList<Integer>();
    }    

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      arr[j].add(k);
      arr[k].add(j);
    }
    count = 0;
    BFS();
    System.out.println(count - 1);
  }

  public static void BFS(){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;
    while(!queue.isEmpty()){
      int cur = queue.poll();
      count += 1;
      for(int i: arr[cur]){
        if (!visited[i]){
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}

/*
 * 
 */