package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

	1부터 N까지 자연수 중에서 M개를 고른 수열
	같은 수를 여러 번 골라도 된다.
		
	input
	4 2
	
	output
	1 1
	1 2
	1 3
	1 4
	2 1
	2 2
	2 3
	2 4
	3 1
	3 2
	3 3
	3 4
	4 1
	4 2
	4 3
	4 4
	
	Solution : 1. 순열 그대로를 받아서 리턴해주면 된다.
			   2. for문에서 반복해서 재귀를 돌려준다.
	   
*/

public class NandM3 {

	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(N, M, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int N, int M, int depth) {
		if(M == depth) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			dfs(N, M, depth+1);
		}
	}

}
