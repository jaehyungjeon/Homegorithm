package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 
	그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

	파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
	
	N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
	
	input
	2
	6
	12
	
	output
	3
	16
	
	Solution : 1. 계속 이어가다 보면 순열의 규칙성이 있음 (N-3) + (N-2) = N
			   2. null일때 체크하도록 해야 중복으로 체크를 안하므로 Long 타입으로 선언

*/

public class WaveSequence {

	public static Long[] dp = new Long[101];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0L;
		dp[1] = dp[2] = dp[3] = 1L;
		
		for(int i=0; i<N; i++) {
			int M = Integer.parseInt(br.readLine());
			
			System.out.println(dpMethod(M));
		}
	}
	
	private static long dpMethod(int N) {
		if(dp[N] == null) {
			dp[N] = dpMethod(N-3) + dpMethod(N-2);
		}
		
		return dp[N];
 	}

}
