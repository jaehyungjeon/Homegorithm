package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.

	두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
	
	input			 
	2 7
	3 5
	
	output
	31 35
	
	Solution : 1. 분수의 계산을 먼저 진행한다.
			   2. 계산된 값에서 최대공약수만큼을 divide 해주면 값 완성.

*/

public class SumFraction {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long C = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());
		
		long top = A * D + B * C;
		long bottom = B * D;
		
		long mod = getGCD(top, bottom);
		top /= mod;
		bottom /= mod;
		
		System.out.print(top + " " + bottom);
		
	}
	
	public static long getGCD(long A, long B) {
		long temp = A % B;
		
		while(temp != 0) {
			A = B;
			B = temp;
			temp = A % B;
		}
		
		return B;
	}
}
