package Array;

import java.util.*;
import java.io.*;

/*
	Question : 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
	예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

	input			 
	150
	266
	427
	
	output
	3
	1
	0
	2
	0
	0
	0
	2
	0
	0
	
	Solution : 배열에 초기화 한번 해주고, while문으로 결괏값 넣어준 다음 다시 for문으로 출력
*/

public class NumCount {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[10];
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int sum = a * b * c;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = 0;
		}
		
		while(sum > 0) {
			int tmpNum = sum%10;
			arr[tmpNum]++;
			sum /= 10;
		}
		
		for(int k : arr) {
			System.out.println(k);
		}
	}
}