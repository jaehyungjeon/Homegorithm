package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.

	영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
	
	각 막대의 길이는 양의 정수이다
	세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
	삼각형의 둘레를 최대로 해야 한다.
	a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오. 
	
	input			 
	1 2 3
	
	output
	5
	
	Solution : 1. 3변이 주어졌을 때, MAX 값 < 나머지 값의 합 이면 삼각형이 됨.

*/

public class ThreeStick {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(sc.nextToken());
		arr[1] = Integer.parseInt(sc.nextToken());
		arr[2] = Integer.parseInt(sc.nextToken());
		
		Arrays.sort(arr);
		if(arr[0] + arr[1] > arr[2]) {
			System.out.println(arr[0] + arr[1] + arr[2]);
		} else {
			int sum = arr[0] + arr[1];
			System.out.println(sum + (sum-1));
		}
	}

}
