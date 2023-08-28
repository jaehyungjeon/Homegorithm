package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

	1부터 N까지 자연수 중에서 M개를 고른 수열
	같은 수를 여러 번 골라도 된다.
	고른 수열은 비내림차순이어야 한다.
	길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
		
	input
	4 2
	
	output
	1 1
	1 2
	1 3
	1 4
	2 2
	2 3
	2 4
	3 3
	3 4
	4 4
	
	Solution : 1. i보다 작은 숫자는 취급하지 않는다.
   			   2. DFS 메소드의 for문 시작이 넘겨준 start 변수에서부터 시작함이 중요점이다.
   			   3. i이상인 수들이 재귀로 형성되며 후에 Builder에 append 된다.
*/

public class NandM4 {

	public static int N, M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int start, int depth) {
		if(M == depth) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			dfs(i, depth+1);
		}
			
	}

}
