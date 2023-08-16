package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

	예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
	1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
	하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.


	어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
	
	input			 
	7
	6
	1 2
	2 3
	1 5
	5 2
	5 6
	4 7
	
	output
	4
	
	Solution : 1. DFS, BFS 학습을 위한 예제.
			   2. node - node로 이동하면서 연결되어 있는 노드가 있고 방문을 했을 경우 answer값을 증가시켜 감염됨을 파악한다.
			   3. DFS의 전형적인 방식을 사용하며, start가 1번에서 시작하므로 최초 변수 초기화가 key이다.

*/

public class WormVirus {

	public static int n,m;
	public static int answer = -1;
	public static int[][] graph;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[n+1][n+1];
		
		/* n -> m 이동 간 노드 값 추가 */
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			
			graph[n1][m1] = 1;
			graph[m1][n1] = 1;
		}
		
		visited = new boolean[n+1];
		int start = 1; // 1번부터 시작할 예정이므로 1로 초기화
		
		dfs(start);
		
		for(int i=1; i<=n; i++) {
			if(visited[i]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for(int i=1; i<visited.length; i++) {
			if(graph[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
