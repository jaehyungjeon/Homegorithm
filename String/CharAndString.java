package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 단어 $S$와 정수 $i$가 주어졌을 때, $S$의 $i$번째 글자를 출력하는 프로그램을 작성하시오.
	
	input			 
	Sprout
	3
	
	output
	r
	
	Solution : 1. 해당 위치의 글자를 반환해주면 된다. (charAt 사용)

*/

public class CharAndString {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(str.charAt(N - 1));
	}

}
