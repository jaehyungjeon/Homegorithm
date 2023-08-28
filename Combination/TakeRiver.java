package Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 
	하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다. 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 
	재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)

	재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 
	재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 
	다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
	
	input
	3
	2 2
	1 5
	13 29
	
	output
	1
	5
	67863915
	
	Solution : 1. nCm = n! / m!*(n-m)!
			   2. Combination 공식을 이용하면 된다.
			   3. dp를 이용한 분할정복 사용
			   4. 보내는 쪽(n)을 하나씩 감소하면서 있으면 추가해준다.
			   5. 이미 탐색이 되었으면 값을 바로 리턴해준다. (dp[n][r] > 0 일 경우, 바로 리턴)
*/

public class TakeRiver {

	public static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			System.out.println(combi(r,n));
		}
		
		br.close();
	}
	
	private static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		} else if(r == 0 || n == r) {
			return dp[n][r] = 1;
		} else {
            return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
		}
	}
}
