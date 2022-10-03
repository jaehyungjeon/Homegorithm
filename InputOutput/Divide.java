package InputOutput;

import java.util.*;
import java.io.*;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오
		
	input			 
	1 3
	
	output
	0.33333333333333333333333333333333
	
	Solution : 나누기
*/

public class Divide {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		double a = Double.parseDouble(sc.nextToken());
		double b = Double.parseDouble(sc.nextToken());
		double count = a/b;
		
		System.out.println(count);
	}
}
