package Array;

import java.util.*;
import java.io.*;

/*
	Question : N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

	input			 
	5
	20 10 35 30 7
	
	output
	7 35
	
	Solution : 초기값을 놓고 max, min이랑 배열의 숫자랑 비교해서 최대, 최소 값 구하기
*/

public class MaxMin {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String[] arr = new String[count];
		
		arr = br.readLine().split(" ");
		
		int min = Integer.parseInt(arr[0]);
		int max = Integer.parseInt(arr[0]);
		for(int i=1; i<arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			
			if(num > max) max = num;
			if(num < min) min = num;
		}
		
		System.out.println(min + " " + max);
	}
}