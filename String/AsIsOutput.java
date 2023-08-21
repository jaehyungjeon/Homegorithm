package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 입력 받은 대로 출력하는 프로그램을 작성하시오.

	input			 
	Hello
	Baekjoon
	Online Judge
	
	output
	Hello
	Baekjoon
	Online Judge
	
	Solution : 1. 더 이상 입력받는 라인이 없을 경우 프린트
*/

public class AsIsOutput {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		
		br.close();
	}

}
