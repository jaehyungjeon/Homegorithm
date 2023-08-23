package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
	
	input
	3 16
	
	output
	3
	5
	7
	11
	13
	
	Solution : 1. 소수를 구하는 로직을 그대로 사용.
			   2. prime일 경우 값을 출력해주면 됨.
			   3. 값을 받을때 int(정수형)가 아닌 long으로 받아주어야 정답처리됨.

*/

public class FindDecimal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long M = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		for(long i=M; i<=N; i++) {
			var bi = new BigInteger(String.valueOf(i));

			if (bi.isProbablePrime(10)) { // 소수 판별
				System.out.println(i);
			}
		}
	}

}
