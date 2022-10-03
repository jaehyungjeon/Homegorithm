package Loop;

import java.util.*;
import java.io.*;

/*
	Question : n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

	input			 
	3
	
	output
	6
	
	Solution : 반복문을 이용한 합
*/

public class Sum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=1; i<=a; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}