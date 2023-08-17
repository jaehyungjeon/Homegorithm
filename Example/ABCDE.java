package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

	오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
	
	A는 B와 친구다.
	B는 C와 친구다.
	C는 D와 친구다.
	D는 E와 친구다.
	위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
	
	input			 
	5 4
	0 1
	1 2
	2 3
	3 4
	
	output
	1
	
	Solution : 1. 정점의 개수 : 5 / 연결의 수 : 4
			   2. list로 구성하는 배열에 Vertex에 따른 Arrival의 변경이 계속 이루어져야 한다.
			   3. 배열에 등록한 다음지점까지 탐색을 실시하면서 방문 탐색을 실시한다.
			   4. 5지점을 모두 통과했을 경우 1을 return, 아닐 경우 초기화된 answer를 반환한다.

*/

public class ABCDE {

	public static int n,m;
	public static int answer = 0;
	public static List<Integer>[] list;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 1. 정점 - 정점 map에 값 지정
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st2.nextToken());
			int m1 = Integer.parseInt(st2.nextToken());
		
			list[n1].add(m1);
			list[m1].add(n1);
		}
		
		// 2. DFS 탐색
		answerMethod();
		
		br.close();
	}
	
	// DFS
	private static void dfs(int start, int depth) {
		// A, B, C, D, E 모든 정점을 거친 케이스
		if(depth == 5) {
			answer = 1;
			return;
		}
		
		visited[start] = true;

		for(int i=0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			// start 변수의 도착지의 방문여부를 파악하여 방문하지 않았을 경우 재탐색을 실시한다.
			if(!visited[next]) {
				dfs(next, depth + 1);
			}
		}
		
		visited[start] = false;
	}
	
	private static void answerMethod() { 
		for(int i=0; i<n; i++) {
			if(answer == 0) {
				dfs(i, 1);
			}
		}
		
		System.out.println(answer);
	}
}
