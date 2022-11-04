package Array;

import java.util.*;
import java.io.*;

/*
	Question : 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

	input			 
	11
	1 4 1 2 4 2 4 2 3 4 4
	2
	
	output
	3
	
	Solution : 그냥 쉽게 생각하면 풀리는 문제.. 어차피 정수 비교라 String으로 받고 String eqauls로 비교해도 무방해서 넣었음.
*/

public class FindNum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String[] arr = new String[total];
		
		arr = br.readLine().split(" ");
		
		String v = br.readLine();
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(v)) count++; 
		}
		
		System.out.println(count);
	}
}