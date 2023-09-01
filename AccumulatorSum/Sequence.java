package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.

	예를 들어, 아래와 같이 10일 간의 온도가 주어졌을 때,
	3 -2 -4 -9 0 3 7 13 8 -3
	모든 연속적인 이틀간의 온도의 합은 아래와 같다.
	
	이때, 온도의 합이 가장 큰 값은 21이다.
	또 다른 예로 위와 같은 온도가 주어졌을 때, 모든 연속적인 5일 간의 온도의 합은 아래와 같으며,
	
	이때, 온도의 합이 가장 큰 값은 31이다.
	매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오.

	input
	10 2
	3 -2 -4 -9 0 3 7 13 8 -3
	
	output
	21
	
	Solution : 1. 배열에 누적으로 된 합을 넣어준다.
			   2. 비교해 줄 범위의 수는 각 배열의 누적합으로 담겨있기 때문에 단계를 거치면서 해당 누적값에서 범위에 해당하지 않는 누적값을 차감한다.
			   3. 예를들어 6번째 배열에는 3-2-4-9+0+3의 값이 있을 것이고 해당 범위는 2~6번째의 값만 추출할 것이기 때문에 3-2-4-9+0+3 값에서 첫번째인 3을 빼주면 된다.
			   4. Max값과 비교하여 최대값을 도출한다. 
	
*/

public class Sequence {

	public static int Max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=M; i<=N; i++) {
			Max = Math.max(Max, arr[i] - arr[i-M]);
		}
		
		System.out.println(Max);
	}
}
