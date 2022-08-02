package Condition;

import java.util.*;
import java.io.*;

/*
	Question : 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

	input			 
	1 2
	
	output
	<
	
	Solution : 비교
*/

public class Compare {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(sc.nextToken());
		int b = Integer.parseInt(sc.nextToken());
		
		if(a > b) sb.append(">");
		else if (a < b) sb.append("<");
		else sb.append("==");
		
		System.out.println(sb.toString());
	}
}
