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
	
	Solution : 1. 기존 값에서 -1하는것과 2, 3으로 나눈 것 중에서 최소인 횟수를 리턴해준다.

*/

public class MakeOne {
	
	public static Integer[] dp;
	public static int[] arr;
	public static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = dp[1] = 0;
		
		System.out.println(dpMethod(N));
	}
	
	private static int dpMethod(int N) {
		if(dp[N] == null) {
			if(N%6 == 0) { // 2와 3의 배수인 6으로 나누었을때 2와 3으로 나눈 것 중 최소를 구한다.
				dp[N] = Math.min(dpMethod(N-1), Math.min(dpMethod(N/3), dpMethod(N/2))) + 1;
			} else if(N%3 == 0) {
				dp[N] = Math.min(dpMethod(N-1), dpMethod(N/3)) + 1;
			} else if(N%2 == 0) {
				dp[N] = Math.min(dpMethod(N-1), dpMethod(N/2)) + 1;
			} else {
				dp[N] = dpMethod(N-1) + 1;
			}
		}
		
		return dp[N];
	}

}
