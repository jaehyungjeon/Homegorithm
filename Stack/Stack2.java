package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
	Question : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

	명령은 총 다섯 가지이다.
	
	1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
	2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
	3: 스택에 들어있는 정수의 개수를 출력한다.
	4: 스택이 비어있으면 1, 아니면 0을 출력한다.
	5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
	
	input			 
	9
	4
	1 3
	1 5
	3
	2
	5
	2
	2
	5
	
	output
	1
	2
	5
	3
	3
	-1
	-1
	
	Solution : 1. 조건에 맞추어 Swtich - Case문을 활용한 스택 내용 출력

*/


public class Stack2 {

	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			switch(command) {
				case 1 :
					stack.add(Integer.parseInt(st.nextToken()));
					break;
				case 2 :
					sb.append(stack.isEmpty() ? -1 : stack.pop());
					sb.append("\n");
					break;
				case 3 :
					sb.append(stack.size());
					sb.append("\n");
					break;
				case 4 :
					sb.append(stack.isEmpty() ? 1 : 0);
					sb.append("\n");
					break;
				case 5 : 
					sb.append(stack.isEmpty() ? -1 : stack.peek());
					sb.append("\n");
					break;
				
			}
		}
		
		System.out.println(sb.toString());
	}

}
