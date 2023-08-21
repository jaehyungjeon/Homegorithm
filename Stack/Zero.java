package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	Question : 
	나코더 기장 재민이는 동아리 회식을 준비하기 위해서 장부를 관리하는 중이다.
	
	재현이는 재민이를 도와서 돈을 관리하는 중인데, 애석하게도 항상 정신없는 재현이는 돈을 실수로 잘못 부르는 사고를 치기 일쑤였다.
	
	재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
	
	재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다. 재민이를 도와주자!
	
	input			 
	4
	3
	0
	4
	0
	
	----------------------
	
	10
	1
	3
	5
	4
	0
	0
	7
	0
	0
	6
	
	output
	0
	
	----------------------
	
	7
	
	Solution : 1. 조건에 맞추어 Swtich - Case문을 활용한 스택 내용 출력

*/

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
