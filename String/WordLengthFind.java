package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.

	input			 
	pulljima
	
	output
	8
	
	Solution : 1. Length 함수를 이용한다.

*/

public class WordLengthFind {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		System.out.println(str.length());
	}

}
