package Sort;

import java.util.*;
import java.io.*;

/*
	Question : 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

	input			 
	3
	21 Junkyu
	21 Dohyun
	20 Sunyoung
	
	output
	20 Sunyoung
	21 Junkyu
	21 Dohyun
	
	Solution : 1. 배열로 받아서 age 비교
			   2. 나머지는 그대로 정렬될 것임.
	
*/

public class AgeSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		String[][] arr = new String[count][2]; 
				
		for(int i=0; i<count; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			arr[i][0] = sc.nextToken(); // age
			arr[i][1] = sc.nextToken(); // name
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		for(String[] str : arr) {
			for(String t : str) {
				sb.append(t + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}