import java.util.*;

public class Problem1167 {
  static int N;
  static ArrayList<Node>[] arr;
  static boolean[] visited;
  static int[] distance;

  public static class  Node {
    int e;
    int value;
    public Node(int e, int v){
      this.e = e;
      this.value = v;
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    visited = new boolean[N+1];
    distance = new int[N+1];
    arr = new ArrayList[N + 1];
    for(int i = 0;i<=N; i++){
      arr[i] = new ArrayList<Node>();
    }
    for(int i =0; i<N; i++){  
      sc.nextLine();
      int index = sc.nextInt();
      while(true){
        int E = sc.nextInt();
        if (E == -1 ){
          break;
        }
        int V = sc.nextInt();
        arr[index].add(new Node(E,V));
      }
    }
    BFS(N/2);
    int max = 1;
    for(int i = 2; i<=N; i++){
      if(distance[max] < distance[i]){
        max = i;
      }
    }
    visited = new boolean[N+1];
    distance = new int[N+1];
    BFS(max);
    Arrays.sort(distance);
    System.out.println(distance[N]);
  }

  public static void BFS(int now){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(now);
    visited[now] = true;
    while(!queue.isEmpty()){
      int cur_node = queue.poll();
      for(Node n : arr[cur_node]){
        int e = n.e;
        int v = n.value;
        if(!visited[e]){
          visited[e] = true;
          queue.add(e);
          distance[e] = distance[cur_node] + v;
        }
      }

    }
  }
}


/*
 * 범위 
 * V : 트리의 정점 : 2 <= V <= 100,000
 */
