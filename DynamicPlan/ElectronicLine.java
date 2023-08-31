package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
	Question : 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 
	합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

	예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, 
	A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
	
	전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 
	전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
		
	input
	8
	1 8
	3 9
	2 2
	4 1
	6 4
	10 10
	9 7
	7 6
	
	output
	3
	
	Solution : 1. 해결 방법은 의외로 간단하다. 전체에서 겹쳐지는 것의 Max를 차감해주면 된다.
			   2. 그러기 위해서 Start 되는 부분을 먼저 정렬해준다. (오름차순 정렬)
			   3. dp를 활용하여 도착점보다 이전의 도착지점들이 작으면 겹쳐지는 것으로 한다.

*/

public class ElectronicLine {

	public static int[][] arr;
	public static int[] dp;
	public static int Max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// Start 순서대로 정렬.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j][1] < arr[i][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}

			Max = Math.max(dp[i], Max);
		}
		
		System.out.println(N - Max);
	}

}
