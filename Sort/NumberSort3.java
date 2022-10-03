package Sort;

import java.util.*;
import java.io.*;

/*
	Question : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

	input			 
	10
	5
	2
	3
	1
	4
	2
	3
	5
	1
	7
	
	output
	1
	1
	2
	2
	3
	3
	4
	5
	5
	7
	
	Solution : 1. StringBuilder 쓰는 것보다 BufferedWriter가 속도가 더 빨라서 바꿈.
*/

public class NumberSort3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine()); // 받는 갯수
		int[] arr = new int[count];
		for (int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int val : arr) {
			bw.append(val + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
