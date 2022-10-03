package InputOutput;

import java.util.*;
import java.io.*;

/*
	Question : 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
		
	input			 
	7 3
	
	output
	10
	4
	21
	2
	1
	
	Solution : 사칙연산
*/

public class ArithmeticOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(sc.nextToken());
		int b = Integer.parseInt(sc.nextToken());
		
		int sum = a+b;
		System.out.println(sum);
		
		int minus = a-b;
		System.out.println(minus);
		
		int mul = a*b;
		System.out.println(mul);
		
		int div = a/b;
		System.out.println(div);
		
		int divisor = a%b;
		System.out.println(divisor);
	}

}
