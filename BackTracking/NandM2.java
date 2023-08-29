package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question :	자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	고른 수열은 오름차순이어야 한다.
		
	input
	4 2
	
	output
	1 2
	1 3
	1 4
	2 3
	2 4
	3 4
	
	Solution : 1. 앞선 문제와 다르게 한번 방문한 노드는 더이상 방문하지 않는 것을 목표로 한다.
			   2. visitied를 사용하게 되면 기존의 노드를 방문하지 않기때문에 단순한 재귀를 활용한다.
		   
*/

public class NandM2 {

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
			dfs(i+1, depth+1); // i+1 해줌으로서, 같은 행의 위치는 재귀하지 않음. ex) 2-2 (x), 2-3(o) .... -> 8-2(x), 8-9(o)
		}
	}
}
