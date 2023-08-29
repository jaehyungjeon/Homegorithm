package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

	어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 
	결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
	
	그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. 
	(01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
	
	우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.
		
	input
	4
	
	output
	5
	
	Solution : 1. dp를 활용하여 재귀를 활용한 method 구현
			   2. 0, 1, 2를 제외한 나머지 상황에서는 dp를 활용하여 동적인 호출함.
			   3. 리턴값에 15746을 나눈 나머지를 배열에 담아 리턴.
			   4. 00으로 나오지 않으면 없는 것으로 체크함. ex) 00000 (x), 10011 (o), 00100 (o)
			   5. 1 2 3 5 8 13 .... 순서로 순열이 진행되므로 dp를 사용한 피보나치 알고리즘이라고 생각하면 된다.

*/

public class Tile01 {

	public static int N;
	public static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(dpMethod(N));
	}
	
	private static int dpMethod(int N) {
		if(dp[N] == -1) {
			dp[N] = (dpMethod(N-1) + dpMethod(N-2)) % 15746;
		}
		
		return dp[N];
	}
}
