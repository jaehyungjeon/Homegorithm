package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. 
	<그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

	예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
	
	계단 오르는 데는 다음과 같은 규칙이 있다.
	
	계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
	연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
	마지막 도착 계단은 반드시 밟아야 한다.
	따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
	
	각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
		
	input
	6
	10
	20
	15
	25
	10
	20
	
	output
	75
	
	Solution : 1. 먼저 계단별 점수를 받는다.
			   2. 개념의 이해는 2칸을 튀어오를때와 한칸씩 튀어오를때의 최대를 구할때 어떤값이 더 큰 경우인가를 탐색하는 것이다.
			   3. 연속적으로 3번을 밟지 않는다고 하였으므로 이전에 연속으로 밟지 않은 케이스들의 최댓값을 밟은 층의 값과 합산한다.

*/

public class StairClimb {

	public static int N;
	public static int[] arr, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[301];
		dp = new int[301];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];
		
		for(int i=4; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
		}
		
		System.out.println(dp[N]);
	}
}
