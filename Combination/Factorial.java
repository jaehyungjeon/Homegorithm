package Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
	
	input
	10
	
	output
	3628800
	
	Solution : 1. 팩토리얼 함수
   
*/

public class Factorial {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}

	private static int factorial(int N) {
		if(N == 0) return 1;
		else {
			return N *= factorial(N-1);
		}
	}
}
