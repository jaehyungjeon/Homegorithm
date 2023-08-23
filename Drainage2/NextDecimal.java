package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : 정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

	input
	3
	6
	20
	100
	
	output
	7
	23
	101
	
	Solution : 1. BigInteger를 활용하여 isProbablePrime(10) -> 소수 판별을 진행한다.
			   2. 소수가 아닐 경우 다음 값을 넣어 소수 판별을 진행한다.

*/

public class NextDecimal {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			long K = Long.parseLong(br.readLine());
			var bi = new BigInteger(String.valueOf(K));

			if (bi.isProbablePrime(10)) { // 소수 판별
				System.out.println(K);
			} else {
				System.out.println(bi.nextProbablePrime());
			}
		}

		br.close();
	}
}
