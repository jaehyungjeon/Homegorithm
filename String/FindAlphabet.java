package String;

import java.util.*;
import java.io.*;

/*
	Question : 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

	input			 
	baekjoon
	
	output
	1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
	
	Solution : char을 이용한 문제
*/

public class FindAlphabet {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] num = new int[26];
		
		for(int i=0; i<num.length; i++) {
			num[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(num[c - 'a'] == -1) {
				num[c - 'a'] = i;
			}
		}
		
		for(int val : num) {
			System.out.print(val + " ");
		}
	}
}