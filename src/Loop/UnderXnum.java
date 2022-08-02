package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

	input			 
	10 5
	1 10 4 9 2 3 8 5 7 6
	
	output
	1 4 2 3
	
	Solution : 값 받아서 비교교
*/

public class UnderXnum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int cn = Integer.parseInt(sc.nextToken());
		int num = Integer.parseInt(sc.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<cn; i++) {
			int no = Integer.parseInt(st.nextToken());
			if(no < num) {
				System.out.print(no + " ");
			}
		}
		
	}
}