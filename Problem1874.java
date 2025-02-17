import java.util.*;
public class Problem1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;

        for (int i=0; i<N; i++){
            int now = arr[i];

            while(now >= num){
                stack.add(num);
                num++;
                sb.append("+\n");
            }
            if (now == stack.peek()){
                stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuffer();
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}