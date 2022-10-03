package Condition;

import java.util.*;
import java.io.*;

/*
	Question : 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

	input			 
	100
	
	output
	A
	
	Solution : 점수 별 append
*/

public class TestScore {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int score = Integer.parseInt(br.readLine());
		
		if(score >= 90) sb.append("A");
		else if(score >= 80) sb.append("B");
		else if(score >= 70) sb.append("C");
		else if(score >= 60) sb.append("D");
		else sb.append("F");
		
		System.out.println(sb.toString());
	}
}
