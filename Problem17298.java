import java.io.*;
import java.util.*;

public class Problem17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        for(int i = 0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.add(i);
                continue;
            }
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        if(!stack.isEmpty()){
            for(int k : stack){
                answer[k] = -1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int j: answer){
            sb.append(j + " ");
        }
        System.out.println(sb.toString());
    }
}