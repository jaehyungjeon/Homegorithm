package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.

	input			 
	5
	1 1
	12 34
	5 500
	40 60
	1000 1000
	
	output
	2
	46
	505
	100
	2000
	
	Solution : 반복문을 이용한 합
*/

public class SpeedAB {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=0; i<a; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(sc.nextToken());
			int second = Integer.parseInt(sc.nextToken());
			
			sum = first + second;
			
			sb.append(sum + "\n");
			sum = 0;
		}
		
		System.out.println(sb.toString());
	}
}