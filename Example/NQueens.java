package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

	N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
	
	input			 
	8
	----
	4
	
	output
	92
	----
	2
	
	Solution : 1. 다시 푸는 NQueens 문제. 백트래킹 연습을 위한 알고리즘 이해
			   2. 4일 경우 (1, 3, 0, 2) / (2, 0, 3, 1)인 경우 가능
			   3. 같은 열과 대각선상에 위치하지 않으면 되므로 조건을 분기.

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
		
		nqueens(0);
		
		System.out.println(count);
		br.close();
	}
	
	private static void nqueens(int t) {
		if(t == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			answer[t] = i;
			if(proper(t) && proper2(t)) { // 첫 진입 : 현재 행에 말을 놓음, proper가 true인 경우 : 다음 행에 말을 놓음.
				nqueens(t+1);
			}
		}
	}
	
	private static boolean proper(int k) {
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
	
	/* 위의 탐색조건을 세부적으로 나타내면 해당 메소드처럼 구현하면 된다. */
	private static boolean proper2(int k) {
		if(k == 0) return true;
		else {
			for(int i=0; i<k; i++) {
				if(answer[i] == answer[k]) return false;
				if(Math.abs(k - i) == Math.abs(answer[k] - answer[i])) return false;
			}
			return true;
		}
	}
}
