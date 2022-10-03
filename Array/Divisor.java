package Array;

import java.util.*;
import java.io.*;

/*
	Question : 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
	수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.

	input			 
	1
	2
	3
	4
	5
	6
	7
	8
	9
	10
	
	output
	10
	
	Solution : 나머지 값을 넣어준 다음 비교하여 다를때 count 증가
*/

public class Divisor {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i=0; i<9; i++) {
			arr[i] = in.nextInt() % 42;
		}
		
		int tmp = 0;
		int count = 0;
		for(int j=0; j<arr.length; j++) {
			tmp = 0;
			for(int k=j+1; k<arr.length; k++) {
				if(arr[j] == arr[k]) { // 같을때의 조건
					tmp++;
				}
			}
			
			if(tmp == 0) { // 다르면 count 증가
				count++;
			}
		}
		
		System.out.println(count);
	}
}