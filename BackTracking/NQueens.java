package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

	N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
		
	input
	8
	
	output
	92
	
	Solution : 1. Example에서 한번 풀어본 문제지만 다시 해본다.
			   2. 위/아래/대각선 모두 말을 놓지 않는 경우의 수를 구한다.
			   3. Math.abs를 이용한 절댓값 계산으로 대각선 계산을 진행해주는게 포인트.
*/

public class NQueens {

	public static int N;
	public static int count = 0;
	public static int[] answer;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		
		dfs(0);
		
		System.out.println(count);
		br.close();
	}
	
	private static void dfs(int M) {
		if(N == M) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			answer[M] = i;
			if(property(M)) {
				dfs(M+1);
			}
		}
	}
	
	private static boolean property(int k) {
		if(k == 0) return true;
		else {
			for(int i=0; i<k; i++) {
				if(answer[i] != answer[k] && Math.abs(k-i) != Math.abs(answer[k] - answer[i])) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		}
	}

}
