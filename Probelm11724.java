import java.util.*;

public class Probelm11724 {
  static ArrayList<Integer>[] intArr;
  static boolean visited[];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();
    intArr = new ArrayList[N+1];
    visited = new boolean[N+1];
    //인접 리스트 설정
    for(int i = 1; i < N+1; i++) {
      intArr[i] = new ArrayList<Integer>();
    }
    //인접 리스트 채우기
    for(int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      intArr[u].add(v);
      intArr[v].add(u);
    }
    int count = 0;

    for (int i =1; i<N+1; i++){
      if (!visited[i]){
        count ++;
        DFS(i);
      }
    }
    System.out.println(count);
  }
  public static void DFS(int start){
    if(visited[start]){
      return;
    }
    visited[start] = true;
    for( int i : intArr[start]){
      if(visited[i] == false){
        DFS(i);
      }
    }
  }
}
