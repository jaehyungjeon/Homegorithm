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
	Case #1: 2
	Case #2: 5
	Case #3: 7
	Case #4: 17
	Case #5: 7
	
	Solution : 반복문을 이용한 합
*/

public class CaseSum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(sc.nextToken());
			int second = Integer.parseInt(sc.nextToken());
			
			sum = first + second;
			sb.append("Case #" + i + ": " + sum + "\n");
			sum = 0;
		}
		
		System.out.println(sb.toString());
	}
}