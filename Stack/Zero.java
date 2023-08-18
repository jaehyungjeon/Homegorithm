package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

	public static int N;
	public static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(!stack.isEmpty()) {
					stack.pop(); 
				}
			} else {
				stack.push(num);
			}
		}
		
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.println(answer);
	}
}
