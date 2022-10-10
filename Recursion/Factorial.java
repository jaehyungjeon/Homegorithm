package Recursion;

import java.util.*;
import java.io.*;

/*
	Question : 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

	input			 
	10
	
	output
	3628800
	
	Solution : 단순 팩토리얼 함수 구현
*/

public class Factorial {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(Factorial(num));
	}
	
	public static int Factorial(int n) {
		if(n <= 1) return 1;
		
		return n * Factorial(n-1);
	}
}