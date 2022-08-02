package InputOutput;

import java.util.*;
import java.io.*;

/*
	Question : 준하는 사이트에 회원가입을 하다가 joonas라는 아이디가 이미 존재하는 것을 보고 놀랐다. 준하는 놀람을 ??!로 표현한다. 
	준하가 가입하려고 하는 사이트에 이미 존재하는 아이디가 주어졌을 때, 놀람을 표현하는 프로그램을 작성하시오.
	
	input			 
	joonas
		
	output
	joonas??!

	Solution : ??! 붙이기
*/

public class Question {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String text = br.readLine();
		bw.append(text).append("??!");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
