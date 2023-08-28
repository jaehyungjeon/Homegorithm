package Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
	
	input
	5 2
	
	output
	10
	
	Solution : 1. 이항정리에 대한 개념만 알고있으면 풀 수 있는 문제
			   2. 팩토리얼 함수와 이항계수의 공식을 사용.

*/

public class BinomialCoefficient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(binary(N, K));
	}

	private static int binary(int N, int K) {
		if(K > N || K < 0) return 0;
		else {
			return factorial(N) / (factorial(K) * factorial(N-K));
		}
	}
	
	private static int factorial(int N) {
		if(N == 0) return 1;
		else {
			return N * factorial(N-1);
		}
	}
}
