package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 이 문제는 아주 평범한 배낭에 관한 문제이다.

	한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
	
	준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
	아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

	input
	4 7
	6 13
	4 8
	3 6
	5 12
	
	output
	14
	
	Solution : 1. 0 0 0 0 0  13 13
				  0 0 0 8 8  13 13
				  0 0 6 8 8  13 14
				  0 0 6 8 12 13 14
				  위의 흐름으로 규칙이 진행되고 있다.
			   2. 다음에 오는 무게에서의 최댓값을 구하고 최종적으로 가장 큰 MAX를 구하게 된다.
	
*/

public class NormalBackpack {

	public static int[][] arr, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 무게
		arr = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}
		
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=K; i++) {
			for(int j=1; j<=N; j++) { // 가로부터 채우기를 들어간다.
				dp[j][i] = dp[j-1][i];
				if(i - arr[j][0] >= 0) {
					dp[j][i] = Math.max(dp[j-1][i], arr[j][1] + dp[j-1][i - arr[j][0]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
