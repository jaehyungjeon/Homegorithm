package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

	X가 3으로 나누어 떨어지면, 3으로 나눈다.
	X가 2로 나누어 떨어지면, 2로 나눈다.
	1을 뺀다.
	정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
		
	input
	2
	
	output
	1
	
	Solution : 1. 순차적으로 나올 수 있는 최소의 경우를 구해본 결과, 이전의 dp에서 +1 즉, -1을 한 결과보다 나누어 떨어지는 경우에서 하나를 추가한 것이 더 클 경우 해당 값 리턴
			   2. 3으로 나누어 떨어지는 경우도 2로 나누어 떨어지는 경우와 마찬가지로 동일.
			   3. 최종적으로는 마지막의 dp값을 반환.

*/

public class MakeOne {
	
	public static int[] dp;
	public static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		System.out.println(dp[N]);
	}
}
