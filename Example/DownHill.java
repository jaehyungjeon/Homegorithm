package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
	한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.

	현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 
	그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.

	지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
	
	input			 
	4 5
	50 45 37 32 30
	35 50 40 20 25
	30 30 25 17 28
	27 24 22 15 10
	
	output
	4
	
	Solution : 1. DFS와 DP를 이용하여 값을 지속적으로 증진시키는 문제
			   2. 범위를 벗어나지 않는 케이스 및 값이 작은 경우로 이동하는 것들을 탐색
			   3. DP의 값이 0보다 작을 경우는 다시 DFS로 탐색 실시

*/

public class DownHill {

	public static int n,m;
	public static int[][] map, dp;
	public static int[][] pos = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		//1. 값 초기화
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. dp 초기화
		dp[n-1][m-1] = 1;
		
		//3. dfs 탐색 시작
		dfs(0, 0);
		
		//4. 최초 배열에 값을 증가시키고 있으므로 x = 0, y = 0일 때의 값을 print
		System.out.println(dp[0][0]);
		br.close();
	}
	
	private static void dfs(int x, int y) {
		//3-1. 위치가 우측 최하단으로 이동했을 경우, return
		if(x == n-1 && y == m-1) return;
		
		//3-2. 이미 방문했으면 return
		if(visited[x][y]) return;
		
		visited[x][y] = true;
		for(int i=0; i<pos.length; i++) {
			int nr = x + pos[i][0];
			int nc = y + pos[i][1];
			
			//3-3. 작은 위치로 이동해야 하므로 현재 필드의 값이 이동할 필드의 값보다 작아야 하는 조건 필요(map[x][y] > map[nr][nc])
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[x][y] > map[nr][nc]) {
				if(dp[nr][nc] != 0) { //3-3-1. dp로 계산한 값이 0이 아니면, 증가
					dp[x][y] += dp[nr][nc];
				} else { //3-3-2. 아닐 경우 다른 루트로 다시 dfs 탐색 시작.
					dfs(nr, nc);
					dp[x][y] += dp[nr][nc];
				}
			}
		}
	}
}
