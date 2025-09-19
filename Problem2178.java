import java.util.*;
import java.io.*;

public class Problem2178 {
  static int N;
  static int M;
  static int[][] maze;
  static boolean[][] visited;
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    maze = new int[N][M];
    visited = new boolean[N][M];
    for( int i = 0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      maze[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
    }
    BFS(0, 0);
    System.out.println(maze[N-1][M-1]);
  }

  public static void BFS(int i, int j){
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { i, j});
    while(!queue.isEmpty()){
      int[] now = queue.poll();
      for (int k = 0; k<4; k++){
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];
        if(x >= 0 && x<N && y >= 0 && y<M){
          if( maze[x][y] !=0 && !visited[x][y]){
            visited[x][y] = true;
            maze[x][y] = maze[now[0]][now[1]] + 1;
            queue.offer(new int[]{x,y});
          }
        }
      }
    }
  }
}
