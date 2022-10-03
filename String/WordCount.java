package String;

import java.util.*;
import java.io.*;

/*
	Question : 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

	input			 
	The Curious Case of Benjamin Button
	
	output
	6
	
	Solution : String을 잘라서 카운트만 노출
*/

public class WordCount {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer sc = new StringTokenizer(str, " ");
		
		System.out.println(sc.countTokens());
		
	}
}