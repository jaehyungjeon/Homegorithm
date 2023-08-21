package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
	
	input			 
	3
	ACDKJFOWIEGHE
	O
	AB
	
	output
	AE
	OO
	AB
	
	Solution : 1. charAt을 활용한 인덱스 값 지정
			   2. 문자열을 String으로 치환 후, concat으로 연결 한 뒤 Builder에 추가

*/

public class StringVerbs {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			str = String.valueOf(str.charAt(0)).concat(String.valueOf(str.charAt(str.length()-1)));
			sb.append(str);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
