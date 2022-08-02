package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

	input			 
	5
	
	output
	5
	4
	3
	2
	1
	
	Solution : for문 역으로
*/

public class NReverse {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=num; i>0; i--) {
			System.out.println(i);
		}
	}
}