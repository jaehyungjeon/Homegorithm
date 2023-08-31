package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

	예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

	input
	ACAYKP
	CAPCAK
	
	output
	4
	
	Solution : 1. 개념 접근 이해가 안되어 참고함.
			   2. 부분집합을 구하는 것이기 때문에 그 다음의 배열에 일치하는 수가 있을 경우 해당 수로 배열 전체값을 구성해준다.
			   3. 첫번째 문자열에서 순차적으로 진행하며 일치할 때마다 집합의 카운트를 1씩 증가시킨다.
	
*/

public class LCS {

	public static char[] str1, str2;
	public static Integer[][] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(lcs(str1.length-1, str2.length-1));
	}

	private static int lcs(int a, int b) {
		if(a<0 || b<0) return 0;
		
		if(dp[a][b] == null) {
			dp[a][b] = 0;
			if(str1[a] == str2[b]) { // 같을 경우에는 배열에 +1을 진행하는 순차적 재귀를 실행한다.
				dp[a][b] = lcs(a-1, b-1) + 1;
			} else { // 아닐 경우에는 배열에서 가장 큰 숫자를 뒤이어 반영
				dp[a][b] = Math.max(lcs(a-1, b), lcs(a, b-1));
			}
		}
		
		return dp[a][b];
	}
}
