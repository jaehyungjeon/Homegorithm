package String;

import java.util.*;
import java.io.*;

/*
	Question : N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

	input			 
	1
	1
	
	output
	1
	
	Solution : 스트링으로 받아서 split 후 배열 값들을 정수로 변환한 뒤 + 실시
*/

public class NumberSum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String cnt = br.readLine();
		String[] arr = cnt.split("");
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}
}