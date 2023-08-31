package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

	예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
		
	input
	6
	10 20 10 30 20 50
	
	output
	4
	
	Solution : 1. dp를 활용하여 이전의 값보다 다음의 값이 클 경우 카운트를 증가해주는 원리이다.
			   2. dp의 카운트를 증가하고 이전보다 클 경우에 Max에 담아 최종적으로 리턴해준다.
			   3. 스타트 시점이 i가 2인 케이스부터 시작하므로 i가 1일 경우는 길이가 1이라는 점을 명시하여 출력 후 종료해줄 수 있도록 한다.

*/

public class LIS {

	public static int[] arr, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Max = 0;
		arr = new int[N+1];
		dp = new int[N+1];
		
		if(N == 1) {
			System.out.println(1);
			
			System.exit(0);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if (arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}

			Max = Math.max(Max, dp[i]);
		}
		
		System.out.println(Max);
	}

}
