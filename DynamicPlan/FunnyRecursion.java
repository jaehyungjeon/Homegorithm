package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 재귀 호출만 생각하면 신이 난다! 아닌가요?

	다음과 같은 재귀함수 w(a, b, c)가 있다.
	
	if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
	    1
	
	if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
	    w(20, 20, 20)
	
	if a < b and b < c, then w(a, b, c) returns:
	    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
	
	otherwise it returns:
	    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
	위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)
	
	a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
		
	input
	1 1 1
	2 2 2
	10 4 6
	50 50 50
	-1 7 18
	-1 -1 -1
	
	output
	w(1, 1, 1) = 2
	w(2, 2, 2) = 4
	w(10, 4, 6) = 523
	w(50, 50, 50) = 1048576
	w(-1, 7, 18) = 1
	
	Solution : 1. dp로 계산하지 않으면 결과가 나오지 않음.
			   2. dp의 Max는 20까지만 넣을것이므로 +1한 21까지의 배열을 만들어줌.
			   3. 조건에 따라서 해당 배열에 값을 동적으로 변경.

*/

public class FunnyRecursion {
	
	public static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if(N == -1 && M == -1 && K == -1) break;
			
			sb.append("w(" + N + ", " + M + ", " + K + ") = ")
			.append(recurMethod(N, M, K))
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int recurMethod(int N, int M, int K) {
		if(isValid(N,M,K) && dp[N][M][K] != 0) {
			return dp[N][M][K];
		}
		
		if(N <= 0 || M <= 0 || K <= 0) {
			return 1;
		}
		
		if(N > 20 || M > 20 || K > 20) {
			return dp[20][20][20] = recurMethod(20, 20, 20);
		}
		
		if(N < M && M < K) {
			return dp[N][M][K] = recurMethod(N, M, K-1) + recurMethod(N, M-1, K-1) - recurMethod(N, M-1, K);
		}
		
		return dp[N][M][K] = recurMethod(N-1, M, K) + recurMethod(N-1, M-1, K) + recurMethod(N-1, M, K-1) - recurMethod(N-1, M-1, K-1);
	}
	
	private static boolean isValid(int N, int M, int K) {
		return 0 <= N && N <= 20 && 0 <= M && M <= 20 && 0 <= K && K <= 20;  
	}

}
