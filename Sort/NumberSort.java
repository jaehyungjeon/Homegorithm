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
	
	Solution : 1. 선택 정렬을 이용..!
*/

public class NumberSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine()); // 받는 갯수
		int[] arr = new int[count];
		for (int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<count-1; i++) {
			for(int j=i+1; j<count; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for(int val : arr) {
			System.out.println(val);
		}
	}
}
