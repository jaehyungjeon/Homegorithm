package String;

import java.util.*;
import java.io.*;

/*
	Question : 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

	input			 
	A
	
	output
	65
	
	Solution : 아스키 코드 변환
*/

public class ASCIICode {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println((int)br.readLine().charAt(0));
	}
}