import java.util.*;
import java.io.*;
public class Problem1260 {
  static ArrayList<Integer>[] arr;
  static boolean[] visited;
  static int N;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1];
    arr = new ArrayList[N+1];
    for(int i=0; i<=N;i++){
      arr[i] = new ArrayList<>();
    }

    for(int i=0; i<M;i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      arr[s].add(e);
      arr[e].add(s);
    }
    for(int i=0; i<=N;i++){
      Collections.sort(arr[i]);
    }
    DFS(V);
    sb.append("\n");
    visited = new boolean[N+1];
    BFS(V);
    System.out.println(sb);
  }

  static void DFS(int now){
    visited[now] = true;
    sb.append(now+" ");
    for(int i : arr[now]){
      if(!visited[i]){
        DFS(i);
      }
    }
  }

  static void BFS(int start){
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;

    while(!q.isEmpty()){
      int now = q.poll(); 
      sb.append(now+" ");
      for(int i : arr[now]){
        if(!visited[i]){
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }
}
