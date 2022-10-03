package String;

import java.util.*;
import java.io.*;

/*
	Question : 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
	예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
	aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
	단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

	input			 
	4
	aba
	abab
	abcabc
	a
	
	output
	1
	
	Solution : 이전에 사용하였을 때 boolean = false로 변경하고 카운트에서 제외
*/

public class GroupWordChecker {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<num; i++) {
			String str = br.readLine();
			boolean arr[] = new boolean[26]; // 알파벳 사용 내역
			boolean check = true;

			for(int j=0; j<str.length(); j++) {
				int c = str.charAt(j)-'a';
				if(arr[c]) {
					if(str.charAt(j) != str.charAt(j - 1)) {
						check = false;
						break;
					}
				} else {
					arr[c] = true;
				}
			}
			
			if(check) count++;
		}
		
		System.out.println(count);
	}
}