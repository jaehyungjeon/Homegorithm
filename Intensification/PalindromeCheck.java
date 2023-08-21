package Intensification;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.

	팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 
	
	level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

	input			 
	level
	
	output
	1
	
	Solution : 1. 메소드를 하나 따서, charAt으로 continue or 0 값 리턴 조건 파악.
*/

public class PalindromeCheck {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.println(palindMethod(str));
	}
	
	private static int palindMethod(String str) {
		int medi = (str.length() / 2) + 1;
		for(int i=0; i < medi; i++) {
			char A = str.charAt(i);
			char B = str.charAt(str.length()-(1+i));
			
			if(A==B) continue;
			else return 0;
		}
		return 1;
	}

}
