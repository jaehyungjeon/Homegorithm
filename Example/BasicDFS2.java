package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : DFS 알고리즘의 기본적인 이해를 돕기 위한 연습.
	
	Solution : 1. static Class를 사용한 방법

*/

public class BasicDFS2 {

	public static int n,m;
	public static int answer = 0;
	
	
	static class Node {
		int map[][];
		boolean visited[];
		Queue<Integer> queue;
		
		Node(int n){
			this.map = new int[n][n];
			this.visited = new boolean[n];
			this.queue = new LinkedList<Integer>(); // bfs에서 사용할 것임..
		}
		
		void put(int v, int w) {
			map[v][w] = 1;
			map[w][v] = 1;
		}
		
		// dfs
		void dfs(int start) {
			visited[start] = true;
			
			for(int i=0; i<visited.length; i++) {
				if(map[start][i] == 1 && !visited[i]) {
					dfs(i);
				}
			}
		}
		
		// bfs
		void bfs(int start) {
			visited[start] = true;
			
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
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Node node = new Node(n);
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st2.nextToken());
			int m1 = Integer.parseInt(st2.nextToken());

			node.put(n1, m1);
		}
		
		// 시작을 어떤것으로 할지는 문제의 조건에 따라 다르게 지정한다.
		node.dfs(0);
		node.bfs(0);
		
		br.close();
	}
}
