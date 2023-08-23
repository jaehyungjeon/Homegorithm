package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 
	이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

	두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
	
	input			 
	3
	1 45000
	6 10
	13 17
	
	output
	45000
	30
	221
	
	Solution : 1. 최대공약수를 구한 뒤 최소공배수 값을 계산한다.

*/

public class LCM {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			System.out.println(getLCM(A, B));
		}
	}
	
	// 최대공약수
	private static long getGCD(long A, long B) {
		long temp = A % B;
		
		while(temp != 0) {
			A = B;
			B = temp;
			temp = A % B;
		}
		
		return B;
	}

	// 최소공배수
	private static long getLCM(long A, long B) {
		return (A * B) / getGCD(A, B);
	}
}
