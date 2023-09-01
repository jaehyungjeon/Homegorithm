package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

	예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
	
	1	2	3	4
	2	3	4	5
	3	4	5	6
	4	5	6	7
	여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
	
	표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

	input
	4 3
	1 2 3 4
	2 3 4 5
	3 4 5 6
	4 5 6 7
	2 2 3 4
	3 4 3 4
	1 1 4 4
	
	output
	27
	6
	64
	
	Solution : 1. 행별 구간합을 구한 뒤, 최소된 누적값을 빼준것을 리턴해주면 된다.
			   2. 쉬웠던 문제.
			   3. 같은 행/열이 들어왔을때 분기처리와 그렇지 않을때에는 어떻게 분기하면 되는지 파악하면 쉽다.
		
*/

public class SectionSumFive {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x1 == x2 && y1 == y2) {
				sb.append(arr[x1][y1] - arr[x1][y1-1]).append("\n");
			} else {
				for(int i=x1; i<=x2; i++) {
					sum += (arr[i][y2] - arr[i][y1-1]);
				}
				sb.append(sum).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
