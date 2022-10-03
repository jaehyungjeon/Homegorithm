package Sort;

import java.util.*;
import java.io.*;

/*
	Question : 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

	input			 
	2143
	
	output
	4321
	
	Solution : 1. list 내림차순 정렬 실시
*/

public class SortInside {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String num = br.readLine();
		String[] num_arr = num.split("");
		
		List<Integer> list = new ArrayList<>();
		for(String str : num_arr) {
			list.add(Integer.parseInt(str));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int val : list) {
			sb.append(val);
		}
		
		System.out.println(sb.toString());
	}
}
