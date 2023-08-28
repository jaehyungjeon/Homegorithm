package Intensification2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
	
	input
	2
	4 2
	
	output
	8
	
	Solution : 1. 최솟값 * 최댓값
	
*/

public class Measure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while(N-- > 0) {
			int val = Integer.parseInt(st.nextToken());
			max = (max > val) ? max : val;
			min = (min < val) ? min : val;
		}
		
		System.out.println(max * min);
		
	}

}
