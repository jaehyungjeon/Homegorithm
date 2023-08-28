package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
	Question : 한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.

	queuestack의 구조는 다음과 같다. 
	$1$번, $2$번, ... , $N$번의 자료구조(queue 혹은 stack)가 나열되어있으며, 각각의 자료구조에는 한 개의 원소가 들어있다.
	
	queuestack의 작동은 다음과 같다.
	 
	$x_0$을 입력받는다.
	 
	$x_0$을 $1$번 자료구조에 삽입한 뒤 $1$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 	$x_1$이라 한다.
	$x_1$을 $2$번 자료구조에 삽입한 뒤 $2$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 	$x_2$이라 한다.
	...
	 
	$x_{N-1}$을 $N$번 자료구조에 삽입한 뒤 $N$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 $x_N$이라 한다.
	$x_N$을 리턴한다.
	도현이는 길이 $M$의 수열 $C$를 가져와서 수열의 원소를 앞에서부터 차례대로 queuestack에 삽입할 것이다. 이전에 삽입한 결과는 남아 있다. (예제 $1$ 참고)
	queuestack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.
	
	input
	4
	0 1 1 0
	1 2 3 4
	3
	2 4 7
	
	output
	4 1 2
	
	Solution : 1. 원리는 자료구조 상 큐(0)일 때는 이전의 자릿수로 교체해주는 것이다.
			   2. 따라서, 해당 큐의 타입이 0일 경우에 들어온 value를 현재 자리로 교체해주고, 기존의 데이터는 다른 큐 타입을 만나면 교체해주는 방식이다.
			   3. 출력되는 수는 밀려난 value 즉, 기존에 들어있으나 큐가 진행됨에 따라 밀려난 값을 append 해주는 것이다.
			   4. StringBuilder 안써주면 계속 프린트 되는 동작이 실행되므로 시간초과 에러가 나옴.

*/

public class QueueStack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
			int val = Integer.parseInt(st2.nextToken());
			if(st.nextToken().equals("0")) { // Queue
				queue.addLast(val);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		
		br.close();
		if(queue.isEmpty()) {
			System.out.println(str);
		} else {
			while(M-- > 0) {
				queue.addFirst(Integer.parseInt(st.nextToken()));
				sb.append(queue.pollLast() + " ");
			}
			
			System.out.println(sb.toString());
		}
	}

}
