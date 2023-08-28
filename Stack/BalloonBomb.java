package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
	Question : 1번부터 N번까지 N개의 풍선이 원형으로 놓여 있고. i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다. 
	단, 1번 풍선의 왼쪽에 N번 풍선이 있고, N번 풍선의 오른쪽에 1번 풍선이 있다. 
	각 풍선 안에는 종이가 하나 들어있고, 종이에는 -N보다 크거나 같고, N보다 작거나 같은 정수가 하나 적혀있다. 이 풍선들을 다음과 같은 규칙으로 터뜨린다.

	우선, 제일 처음에는 1번 풍선을 터뜨린다. 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다. 
	양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다. 이동할 때에는 이미 터진 풍선은 빼고 이동한다.
	
	예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자. 
	이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선, 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다.
	
	input
	5
	3 2 1 -3 -1
	
	output
	1 4 5 3 2
	
	Solution : 1. 데크를 이용하여 수를 앞/뒤로 붙여주는 사항에 대한 정의이다.
			   2. 양수일 경우는 앞의 수를 뒤에다 붙인다.
			   3. 음수일 경우는 뒤의 수를 앞에다 붙인다.

*/

public class BalloonBomb {

	public static class Balloon {
		int idx;
		int val;
		
		public Balloon(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Balloon> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		// 큐에 1~N을 담아줌.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			queue.add(new Balloon(i, Integer.parseInt(st.nextToken())));
		}
		
		while(!queue.isEmpty()) {
			sb.append(queue.getFirst().idx + " ");
			int next = queue.poll().val;
			
			if(queue.isEmpty()) break;
			
			if(next > 0) { // 양수일 경우
				for(int i=0; i<next-1; i++) {
					queue.addLast(queue.pollFirst());
				}
			} else { // 음수일 경우, 절댓값으로 뒤의 수를 앞으로 붙여준다.
				for(int i=0; i<Math.abs(next); i++) {
					queue.addFirst(queue.pollLast());
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
