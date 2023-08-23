package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 정수 B에 0보다 큰 정수인 N을 곱해 정수 A를 만들 수 있다면, A는 B의 배수이다.

	예:
	
	10은 5의 배수이다 (5*2 = 10)
	10은 10의 배수이다(10*1 = 10)
	6은 1의 배수이다(1*6 = 6)
	20은 1, 2, 4,5,10,20의 배수이다.
	
	input			 
	121 199
	
	output
	24079
	
	Solution : 1. LCM 프로젝트의 로직에서 변형을 안해도 될 것 같음..

*/

public class LCM2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken()); 

		System.out.println(getLCM(A, B));
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
