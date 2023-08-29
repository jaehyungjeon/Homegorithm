package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 
		
	input
	4 2
	
	output
	1 2
	1 3
	1 4
	2 1
	2 3
	2 4
	3 1
	3 2
	3 4
	4 1
	4 2
	4 3
	
	Solution : 1. 전형적인 Backtracking 문제이다.
			   2. DFS를 활용하여 현재의 depth에 도달했을 때 출력한다.
			   3. 이미 방문했을 경우 true 처리를 해주고, 이전 노드로 탐색을 위해서 마지막에 visited를 false로 변경해준다.
			   4. 재귀가 진행될수록 depth가 1씩 증가한다.
			   
*/

public class NandM1 {

	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N];
		
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
			if(!visited[i]) { // 동일한 위치에는 방문하지 않겠다. ex) 1-1, 2-2, 3-3...
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visited[i] = false;
			}
		}
	}
}
