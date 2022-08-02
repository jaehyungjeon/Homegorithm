package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

	input			 
	5
	1 1
	2 3
	3 4
	9 8
	5 2
	
	output
	2
	5
	7
	17
	7
	
	Solution : 반복문
*/

public class ABMinusThree {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(sc.nextToken());
			int B = Integer.parseInt(sc.nextToken());
			
			System.out.println(add(A, B));
		}
	}
	
	public static int add(int A, int B) {
		return A+B;
	}
}