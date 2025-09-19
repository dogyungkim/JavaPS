import java.util.*;
import java.util.stream.*;
public class Problem2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1,N+1).forEach(e -> queue.offer(e));
        while(queue.size() > 1){
            queue.poll();
            int next = queue.poll();
            queue.offer(next);
        }
        System.out.println(queue.peek());
    }
}