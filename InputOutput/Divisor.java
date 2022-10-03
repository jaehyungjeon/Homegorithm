package InputOutput;

import java.util.*;
import java.io.*;

/*
	Question : (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
	(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
	세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
	
	input			 
	5 8 4
		
	output
	1
	1
	0
	0

	Solution : 연산
*/

public class Divisor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(sc.nextToken());
		int B = Integer.parseInt(sc.nextToken());
		int C = Integer.parseInt(sc.nextToken());
		
		int first = (A+B)%C;
		int second = ((A%C) + (B%C))%C;
		int third = (A*B)%C;
		int fourth = ((A%C) * (B%C))%C;
		
		System.out.println(first + "\n" + second + "\n" + third + "\n" + fourth);
	}
}
