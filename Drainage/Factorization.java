package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
	
	input			 
	72
	
	output
	2
	2
	2
	3
	3
	
	Solution : 1. 1이 아닌 값을 나누면서 나머지가 0인 케이스가 해당 소인수에 해당하므로 재귀를 활용하자.
			   2. 나눈 몫이 idx와 같을 경우는 더 이상 나눠질 수 없으므로 print 후 break 시킨다.
			   3. idx가 1보다 큰 경우이면서 나머지가 0인 케이스는 divide 되는 케이스이므로 value값을 나눈 다음에 재귀 함수를 돌려준다.

*/

public class Factorization {

	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N != 1) devideMethod(N);
	}

	private static void devideMethod(int value) {
		int idx = 1;
		while(true) {
			if(N == idx) {
				System.out.println(idx);
				break;
			} else if(N%idx == 0 && idx > 1) {
				N /= idx;
				System.out.println(idx);
				devideMethod(N);
				break;
			}
			idx++;
		}
	}
}
