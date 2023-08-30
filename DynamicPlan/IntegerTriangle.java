package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

	맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 
	아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
	
	삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
		
	input
	5
	7
	3 8
	8 1 0
	2 7 4 4
	4 5 2 6 5
	
	output
	30
	
	Solution : 1. 문제만으로는 접근하기 어려웠던..
			   2. 해결방안은 해당 위치의 왼/오른쪽 대각선의 값만 추출한다고 하였으니 col, col+1의 값을 비교해주면 된다.
			   3. 처음 개념을 생각했을때 가장 어렵게 느껴진 부분은 다음 줄의 최댓값을 찾는 과정이 아닌 반복수행을 통해 최적의 결과를 도출하는게 어려웠다.
			   4. top-down 방식으로 진행하기에 dp 메소드의 재귀 호출로 진행하면 된다. 

*/

public class IntegerTriangle {

	public static int[][] arr;
	public static Integer[][] dp;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new Integer[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		
		System.out.println(dp(0, 0));
	}

	private static int dp(int col, int depth) {
		if(depth == N-1) {
			return dp[depth][col];
		}
		
		if(dp[depth][col] == null) {
			dp[depth][col] = Math.max(dp(col, depth+1), dp(col+1, depth+1)) + arr[depth][col];
		}
		
		return dp[depth][col];
	}
}
