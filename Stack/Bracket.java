package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	Question : 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 
	그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 
	만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 
	그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 
	
	예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 

	여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
	
	input
	6
	(())())
	(((()())()
	(()())((()))
	((()()(()))(((())))()
	()()()()(()()())()
	(()((())()(
	
	output
	NO
	NO
	YES
	NO
	YES
	NO
	
	Solution : 1. 열린 괄호 뒤에 닫힌 괄호가 있는지를 탐색하면 된다.

*/

public class Bracket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			Stack<Character> stack = new Stack<>(); // 문자를 담는 스택
			String verb = br.readLine();

			stack.add(verb.charAt(0)); // 첫번째 문자는 무조건 담는다.
			for(int j=1; j<verb.length(); j++) {
				if(!stack.isEmpty()) {
					char peek = stack.peek();
					if(peek == '(') { // 괄호가 '('로 들어갔을 경우
						switch(verb.charAt(j)) {
							case ')' :
								stack.pop();
								break;
							case '(' :
								stack.add(verb.charAt(j));
								break;
						}
					} else {
						stack.add(verb.charAt(j));
					}
				} else {
					stack.add(verb.charAt(j));
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
