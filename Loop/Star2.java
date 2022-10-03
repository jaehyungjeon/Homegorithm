package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

	input			 
	5
	
	output
	    *
	   **
	  ***
	 ****
	*****
	
	Solution : 반복문을 이용한 별
*/

public class Star2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=num; i++) {
			for (int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for (int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}