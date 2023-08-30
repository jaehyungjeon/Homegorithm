package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 45656이란 수를 보자.

	이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
	
	N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
	
	+ 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

	input
	1
	
	output
	9
	
	Solution : 1. 규칙을 살펴보면 다음 row의 [row][i] 는 [row-1][i-1] + [row-1][i+1] 이라는 규칙이 형성되었다.
			   2. 따라서 dp로 구현할때, 처음과 마지막 배열을 제외한 나머지는 두개의 합으로 구해주면 된다.
			   3. 0 1 1 1 1 1 1 1 1 1
			   	  1 1 2 2 2 2 2 2 2 1
				  1 3 3 4 4 4 4 4 4 2
				  3 4 7 7 8 8 8 8 6 4
			   4. 수의 규칙을 보자면 0번째는 이전의 1번째 수, 9번재는 이전의 8번째 수라는 것을 확인할 수 있다.
			   5. 나머지 수는 이전의 i-1 + i+1의 숫자를 더한 것이다.
			   6. 수가 커지면 long 타입으로 담을 수 없는 수가 있기때문에 %mod로 나머지를 담도록 하자
			   7. 덧셈을 한 후의 값도 long 타입을 벗어날 수 있으므로 %mod로 출력하도록 한다.

*/

public class EasyStairCount {

	public static long dp[][];
	public static long mod = 1000000000;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new long[N][10];
		
		for(int i=1; i<10; i++) {
			dp[0][i] = 1;
		}

		for(int i=1; i<N; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][1];
				} else if(j == 9) {
					dp[i][j] = dp[i-1][8];
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
			}
		}
		
		long answer = 0;
		for(int i=0; i<10; i++) {
			answer += dp[N-1][i];
		}
		
		System.out.println(answer % mod);
	}

}
