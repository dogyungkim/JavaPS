import java.util.*;
import java.io.*;

public class Problem11286 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second){
                return o1 > o2 ? 1 : -1;
            } else {
                return first - second;
            }
        });

        for(int i = 0; i<N; i++){
            int next = Integer.parseInt(br.readLine());
            if(next == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(next);
            }
        }
    }
}
