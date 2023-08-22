package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 정수 A, B 가 주어진다. 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.

	input			 
	2
	3

	output
	6

	Solution : 1. A*B 

*/

public class Rectangle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		System.out.println(A*B);
	}

}
