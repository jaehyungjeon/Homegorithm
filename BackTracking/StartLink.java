package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 
	축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

	BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
	능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 
	팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

	N=4이고, S가 아래와 같은 경우를 살펴보자.
	
	i\j	1	2	3	4
	1	 	1	2	3
	2	4	 	5	6
	3	7	1	 	2
	4	3	4	5	 
	예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.
	
	스타트 팀: S12 + S21 = 1 + 4 = 5
	링크 팀: S34 + S43 = 2 + 5 = 7
	1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.
	
	스타트 팀: S13 + S31 = 2 + 7 = 9
	링크 팀: S24 + S42 = 6 + 4 = 10
	축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 
	위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
		
	input
	4
	0 1 2 3
	4 0 5 6
	7 1 0 2
	3 4 5 0
	
	output
	0
	
	Solution : 1. 

*/

public class StartLink {

	public static int N;
	public static int[][] arr;
	public static boolean[] visited;
	public static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(Min);
	}
	
	private static void dfs(int idx, int depth) {
		if(depth == N/2) {
			diffMethod();
			return;
		}
		
		for(int i=idx; i<N; i++) { // 가로-세로 : N번만큼 재귀
			if(!visited[i]) { // 똑같은 위치는 방문하지 않겠다. ex) 1x1, 2x2 는 방문하지 않음.
				visited[i] = true;
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
		
	}

	public static void diffMethod() {
		int start = 0;
		int link = 0;
 
		for (int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				if (visited[i] && visited[j]) {	// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
					start += arr[i][j];
					start += arr[j][i];
				} else if (!visited[i] && !visited[j]) { // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(start - link);
		
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val, Min);
	}
	
}
