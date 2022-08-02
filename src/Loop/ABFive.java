package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

	input			 
	1 1
	2 3
	3 4
	9 8
	5 2
	0 0
	
	output
	2
	5
	7
	17
	7
	
	Solution : 마지막 0 0 이면 close
*/

public class ABFive {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		while(true) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(sc.nextToken());
			int second = Integer.parseInt(sc.nextToken());
			
			sum = first + second;
			
			if(first == 0 && second == 0) break;
			else sb.append(sum + "\n");
		}
		
		System.out.println(sb.toString());
	}
}