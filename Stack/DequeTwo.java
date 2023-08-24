package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	Question : 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

	명령은 총 여덟 가지이다.
	
	1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
	2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
	3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
	4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
	5: 덱에 들어있는 정수의 개수를 출력한다.
	6: 덱이 비어있으면 1, 아니면 0을 출력한다.
	7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
	8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
	
	input
	11
	6
	1 3
	1 8
	7
	8
	3
	2 5
	1 2
	5
	4
	4
	
	output
	1
	8
	3
	8
	3
	5
	3
	
	Solution : 1. 

*/

public class DequeTwo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<Integer>(); 
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			switch (num) {
				case 1:
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case 3:
					sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
					sb.append("\n");
					break;
				case 4:
					sb.append(deque.isEmpty() ? -1 : deque.pollLast());
					sb.append("\n");
					break;
				case 5:
					sb.append(deque.size());
					sb.append("\n");
					break;
				case 6:
					sb.append(deque.isEmpty() ? 1 : 0);
					sb.append("\n");
					break;
				case 7:
					sb.append(deque.isEmpty() ? -1 : deque.getFirst());
					sb.append("\n");
					break;
				case 8:
					sb.append(deque.isEmpty() ? -1 : deque.getLast());
					sb.append("\n");
					break;
				default:
					break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
