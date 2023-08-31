package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

	input
	5 3
	5 4 3 2 1
	1 3
	2 4
	5 5
	
	output
	12
	9
	1
	
	Solution : 1. 있는대로 풀면 시간초과가 나는 문제이다.
			   2. 누적합을 구하기때문에 배열마다 기존 배열의 합을 담아준다.
			   3. 구간합은 end의 값에서 start 이전의 값들의 합을 빼주면 결과나 나온다.
	
*/

public class SectionSum {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(arr[end] - arr[start-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
