package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : DFS 알고리즘의 기본적인 이해를 돕기 위한 연습.
	
	Solution : 1. static Class를 사용하지 않고 메소드로 구성하는 방법.

*/

public class BasicDFS {

	public static int n,m;
	public static int[][] map;
	public static int answer = 0;
	public static Queue<Integer> queue;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// Start, End에 동일한 Edge 연결을 위한 map 사용
		map = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st2.nextToken());
			int m1 = Integer.parseInt(st2.nextToken());

			// 해당 노드끼리 연관이 있음을 표시한다.
			map[n1][m1] = 1;
			map[m1][n1] = 1;
		}
		
		// 시작을 어떤것으로 할지는 문제의 조건에 따라 다르게 지정한다.
		dfs(0); // DFS
//		bfs(0); // BFS
		br.close();
	}
	
	// DFS
	private static void dfs(int start) {
		visited[start] = true;

		for(int i=0; i<visited.length; i++) {
			if(map[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	// BFS
	private static void bfs(int start) {
		visited[start] = true;
		queue = new LinkedList<Integer>(); // BFS는 큐를 활용하여 계산해준다.
		
		// 큐에 값이 없을때까지 반복한다.
		while(!queue.isEmpty()) {
			int value = queue.poll();
			for(int i=0; i<visited.length; i++) {
				if(map[value][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
