package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

	예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
		
	input
	10
	10 -4 3 1 5 6 -35 12 21 -1
	
	output
	33
	
	Solution : 1. 연속되는 숫자의 합의 동적계산을 진행하면 된다.
			   2. null인 경우에만 체크될 수 있도록 선언은 int가 아닌 Integer로 한다.
			   3. 현재의 수와 이전의 수의 합 중 최댓값을 구하여 dp에 담고 다시 해당 dp의 값과 누산된 Max의 값을 비교해준다.

*/

public class ContinualSum {

	public static int Max = Integer.MIN_VALUE;
	public static int[] arr;
	public static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = Max = arr[0];
		
		dpMethod(N - 1);
		
		System.out.println(Max);
	}
	
	private static int dpMethod(int M) {
		if(dp[M] == null) {
			// 동적으로 계속 합을 더한다.
			dp[M] = Math.max(dpMethod(M-1) + arr[M], arr[M]);
			
			Max = Math.max(Max, dp[M]);
		}
		
		return dp[M];
	}
}
