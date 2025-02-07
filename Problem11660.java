import java.util.Scanner;

public class Problem11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] board = new int[N+1][N+1];
        sc.nextLine();

        for(int i = 1; i<=N; i++){
            board[i][1] = board[i - 1][1] + sc.nextInt();

            for(int j=2; j<=N; j++){
                board[i][j] = board[i][j -1] + board[i-1][j] -board[i-1][j-1] + sc.nextInt();
            }
         }

         int x1,x2;
         int y1,y2;
         int answer;
         for (int k =0; k<M; k++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            answer = board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1]; 
            System.out.println(answer);
         }

    }
}

