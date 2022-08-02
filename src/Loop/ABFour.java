package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

	input			 
	1 1
	2 3
	3 4
	9 8
	5 2
	
	output
	2
	5
	7
	17
	7
	
	Solution : Scanner로 next 여부 파악
*/

public class ABFour {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextInt()){
		
			int a = in.nextInt();
			int b = in.nextInt();
			
			System.out.println(a+b);
		}	
		
		in.close();
	}
}