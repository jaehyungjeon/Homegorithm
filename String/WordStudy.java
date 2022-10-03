package String;

import java.util.*;
import java.io.*;

/*
	Question : 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

	input			 
	Mississipi
	
	output
	?
	
	Solution : str을 대문자로 변환한 다음에 -'A'로 해당 순서에 맞는 카운트를 증가시켜 준다.
			   for문을 돌면서 max값을 변환시켜 주고 만약 max값과 count값이 같을 경우에는 max가 2개 이상이 연속된 것이므로 ?를 출력한다.
*/

public class WordStudy {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str = str.toUpperCase(); // 대문자 변환
		int[] count = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i) - 'A';
			count[num]++;
		}
		
		int max = 0;
		char answer = '?';
		for(int i=0; i<count.length; i++) {
			if(max < count[i]) {
				max = count[i];
				answer = (char)(i+'A');
			} else if(max == count[i]) {
				answer = '?';
			}
		}
		
		System.out.println(answer);
	}
}