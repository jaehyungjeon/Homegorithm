package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

	집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	
	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
		
	input
	3
	26 40 83
	49 60 57
	13 89 99
	
	output
	96
	
	Solution : 1. 행별로 계산이 겹치지 않도록 R/G/B에 따른 dp의 계산을 진행한다.
	 		   2. 이전행과 같은 위치의 값은 더하지 않으므로 해당 col의 위치를 제외한 나머지를 동적으로 계산해준다.
	 		   3. 최종적으로 계산된 값들 즉, 시작점이 R/G/B 에서 출발해서 MIN값으로 계산한 결과의 총합 중 가장 작은 MIN 값을 반환해준다.
	 		   4. solve -> R에서 부터 출발하여 G/B가 최소인 것을 찾는다. 

*/

public class RGBRoad {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3]; // row : dp, col : R/G/B
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
		}
		
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}
