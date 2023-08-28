package Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 베라는 상의 N 벌과 하의 N 벌이 있다. i 번째 상의와 i 번째 하의는 모두 색상 i를 가진다. N 개의 색상은 모두 서로 다르다.

	상의와 하의가 서로 다른 색상인 조합은 총 몇 가지일까?
	
	input
	1
	----
	2
	----
	5
	
	output
	0
	----
	2
	----
	20
	
	Solution : 1. N * (N-1)
		   
*/

public class VeraFashion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(N * (N-1));
	}

}
