package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 또, 1번부터 N번까지 번호가 적혀있는 공을 매우 많이 가지고 있다. 
	가장 처음 바구니에는 공이 들어있지 않으며, 바구니에는 공을 1개만 넣을 수 있다.
	
	도현이는 앞으로 M번 공을 넣으려고 한다. 도현이는 한 번 공을 넣을 때, 공을 넣을 바구니 범위를 정하고, 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다. 
	만약, 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고, 새로 공을 넣는다. 공을 넣을 바구니는 연속되어 있어야 한다.
	
	공을 어떻게 넣을지가 주어졌을 때, M번 공을 넣은 이후에 각 바구니에 어떤 공이 들어 있는지 구하는 프로그램을 작성하시오.
	
	input			 
	5 4
	1 2 3
	3 4 4
	1 4 1
	2 2 2
	
	output
	1 2 1 1 0
	
	Solution : 1. 입력 받은 수 계산

*/

public class InTheBall {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start =  Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int countNum = Integer.parseInt(st.nextToken());
			
			arrMethod(start, end, countNum);
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 0) {
				arr[i] = 0;
			}
			
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void arrMethod(int start, int end, int countNum) {
		for(int i=start-1; i<end; i++) {
			arr[i] = countNum;
		}
	}

}
