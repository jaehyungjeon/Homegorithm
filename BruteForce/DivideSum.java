package BruteForce;

import java.util.*;
import java.io.*;

/*
	Question : 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
	어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 
	따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
	자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

	input			 
	216
	
	output
	198
	
	Solution : 1. 각 자릿수의 합은 10으로 나눈 나머지들을 이용
			   2. 기본으로 변수에 0으로 초기화 하고 전체값과 자릿수값의 합이 tot와 일치하면 result 반환
*/

public class DivideSum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tot = Integer.parseInt(br.readLine());
		
		System.out.println(result(tot));
	}
	
	public static int result(int tot) {
		int result = 0;
		
		for(int i = 0; i < tot; i++) {
			int number = i;
			int sum = 0; 
			
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum + i == tot) {
				result = i;
				break;
			}
		}
		
		return result;
	}
}