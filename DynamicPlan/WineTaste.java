package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 
	효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.

	포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
	연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
	효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 
	1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 
	
	예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
		
	input
	6
	6
	10
	13
	9
	8
	1
	
	output
	33
	
	Solution : 1. 0번째 배열은 사용하지 않는 것으로 하고 N+1만큼의 배열을 생성한다.
			   2. 수열의 점화식을 보면, i-3번째까지 동적으로 값을 계산하고 i-2번째에 먹지 않으면 나머지 i-1, i번을 더하는 과정이다.
			   3. i-1번째에 먹지 않으면 i-2번째까지 동적으로 값을 계산하고 마지막 i번째의 값을 더한다.
			   4. 마지막 i번째에 먹지 않으면, i-1번째까지 동적으로 값을 계산한다.
			   5. 최종적으로 Max를 구하여 리턴할 수 있도록 담아준다.

*/

public class WineTaste {

	public static int N;
	public static int[] dp, arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] , dp[i-3] + arr[i-1]) + arr[i]); 
		}
		
		System.out.println(dp[N]);
	}
}