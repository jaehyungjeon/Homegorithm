package Arithmetic;

import java.util.*;
import java.io.*;

/*
	Question : 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

	1/1	1/2	1/3	1/4	1/5	…
	2/1	2/2	2/3	2/4	…	…
	3/1	3/2	3/3	…	…	…
	4/1	4/2	…	…	…	…
	5/1	…	…	…	…	…
	…	…	…	…	…	…

	이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
	X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

	input			 
	3
	
	output
	2/1
	
	Solution : 대각선을 기준으로 짝수일 때는, 우 - 좌 오름차순 // 홀수일 경우에는, 좌 - 우 오름차순
	
	1 2 6 7 15
	3 5 8 14
	4 9 13
	10 12
	11
*/

public class FindFraction {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
	}
}