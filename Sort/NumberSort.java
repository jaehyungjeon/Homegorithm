package Sort;

import java.util.*;
import java.io.*;

/*
	Question : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

	input			 
	5
	5
	2
	3
	4
	1
	
	output
	1
	2
	3
	4
	5
	
	Solution : 1. Arrays를 이용했다. 편하니까!
			   2. Return도 그냥 StringBuilder가 간편해서 썼음.
*/

public class NumberSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine()); // 받는 갯수
		int[] arr = new int[count];
		for (int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int val : arr) {
			sb.append(val + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
