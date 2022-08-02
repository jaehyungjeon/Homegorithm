package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

	input			 
	5
	
	output
	1
	2
	3
	4
	5
	
	Solution : for문
*/

public class NStamp {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=num; i++) {
			System.out.println(i);
		}
	}
}