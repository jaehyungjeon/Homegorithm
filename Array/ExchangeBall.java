package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 
	바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
	
	도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
	
	공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
	
	input			 
	5 4
	1 2
	3 4
	1 4
	2 2
	
	output
	3 1 4 2 5
	
	Solution : 1. for문을 기반으로 최초 배열에 번호로 초기화 실시
	 		   2. 임시 temp에 값을 넣고 배열 값 교환 실시
	 		   3. 마지막 전까지 공백을 builder에 추가.
	 		   4. 값 반환

*/

public class ExchangeBall {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		// 배열에 값 초기화 한번 실시
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start =  Integer.parseInt(st.nextToken());
			int arrival = Integer.parseInt(st.nextToken());
			
			arrMethod(start, arrival);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]);
			if(i != N-1) {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	// 단순 배열 Exchange Method
	private static void arrMethod(int start, int arrival) {
		int temp = arr[arrival-1];
		arr[arrival-1] = arr[start-1];
		arr[start-1] = temp;
	}

}
