package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : 지구 온난화로 인하여 북극의 빙산이 녹고 있다. 빙산을 그림 1과 같이 2차원 배열에 표시한다고 하자. 
	빙산의 각 부분별 높이 정보는 배열의 각 칸에 양의 정수로 저장된다. 빙산 이외의 바다에 해당되는 칸에는 0이 저장된다. 그림 1에서 빈칸은 모두 0으로 채워져 있다고 생각한다.
	
	빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에, 배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다. 
	단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다. 바닷물은 호수처럼 빙산에 둘러싸여 있을 수도 있다. 따라서 그림 1의 빙산은 일년후에 그림 2와 같이 변형된다.

	그림 3은 그림 1의 빙산이 2년 후에 변한 모습을 보여준다. 2차원 배열에서 동서남북 방향으로 붙어있는 칸들은 서로 연결되어 있다고 말한다. 
	따라서 그림 2의 빙산은 한 덩어리이지만, 그림 3의 빙산은 세 덩어리로 분리되어 있다.
	
	한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오. 
	그림 1의 빙산에 대해서는 2가 답이다. 만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
	
	input			 
	5 7
	0 0 0 0 0 0 0
	0 2 4 5 3 0 0
	0 3 0 2 5 2 0
	0 7 6 2 4 0 0
	0 0 0 0 0 0 0
	
	output
	2
	
	Solution : 1. DFS, BFS 학습을 위한 예제.
			   2. 시간이 지나면서 숫자는 -1씩 감소하며, 탐색을 통해 상하좌우로 연속되는 것이 없으면 해당년수를 반환해준다.
			   3. 상하좌우의 범위에서 벗어났을 경우에는 continue 처리를 위한 pos 선언.
			   4. 자세한 라인별 주석확인.

*/

public class Iceberg {

	public static int n,m;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static int answer = 0; // 0으로 초기화
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		bfs();
	}

	/* DFS 탐색 실시 */
	private static void bfs() {
		while(true) {
			visited = new boolean[n][m];
			int ice = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						// 범위에 대한 유효성 체크
						bfsOfValid(i, j);
						ice++;
					}
				}
			}
			
			if(ice == 0) {
				answer = 0;
				break;
			}
			
			if(ice >= 2) {
				break;
			}

			// 연도에 따른 빙산 필드 감소
			iceMelting();
			answer++;
		}
		
		System.out.println(answer);
	}
	
	/* 필드 유효성 체크 */
	private static void bfsOfValid(int row, int col) {
		// 해당 필드의 값이 0이 아니고, 방문한 이력이 없을 경우 true로 변환
		visited[row][col] = true;
		
		for(int i=0; i<pos.length; i++) {
			int nr = row + pos[i][0];
			int nc = col + pos[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 0 && !visited[nr][nc]) {
				bfsOfValid(nr, nc);
			}
		}
	}
	
	/* 연도에 따른 빙산 필드 감소 */
	private static void iceMelting() {
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] > 0) { // 필드값이 0보다 클 경우만 감소시킨다.
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		/* Queue에서 poll을 진행하면서 감소 실시 */
		while(!queue.isEmpty()) {
			int[] field = queue.poll();
			int minus = 0;
			
			for(int i=0; i<pos.length; i++) {
				int nr = field[0] + pos[i][0];
				int nc = field[1] + pos[i][1];
				
				/* 해당 필드의 값이 0이 아니며, 방문하지 않았을 경우에 minus 해줄 연도 증가  */
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0 && !visited[nr][nc]) {
					minus++;
				}
			}
			
			/* 필드값 - 마이너스 값이 0보다 작으면 0으로 규정한다. */
			int minusYears = map[field[0]][field[1]] - minus;
			if(minusYears < 0) {
				map[field[0]][field[1]] = 0;
			} else {
				map[field[0]][field[1]] = minusYears;
			}
		}
	}
}
