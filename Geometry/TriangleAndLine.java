package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.

	Equilateral :  세 변의 길이가 모두 같은 경우
	Isosceles : 두 변의 길이만 같은 경우
	Scalene : 세 변의 길이가 모두 다른 경우
	단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 
	가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
	
	세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
	
	input
	7 7 7
	6 5 4
	3 2 5
	6 2 6
	0 0 0
	
	output
	Equilateral
	Scalene
	Invalid
	Isosceles
	
	Solution : 1. 배열의 Sort를 활용하여 구하였다.
			   2. 오름차순으로 정렬하여 제일 뒤에있는 값이 MAX가 된다.
			   3. 먼저 valid 검사부터 진행 후 나머지 조건 검사를 진행한다.

*/

public class TriangleAndLine {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		
		while(true) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(sc.nextToken());
			arr[1] = Integer.parseInt(sc.nextToken());
			arr[2] = Integer.parseInt(sc.nextToken());

			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			//정렬
			Arrays.sort(arr);
			
			if(arr[2] >= arr[0] + arr[1]) {
				System.out.println("Invalid");
			}else if(arr[0] == arr[1] && arr[1] == arr[2]) {
				System.out.println("Equilateral");
			}else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
				System.out.println("Isosceles");
			}else {
				System.out.println("Scalene");
			}
		}
	}

}
