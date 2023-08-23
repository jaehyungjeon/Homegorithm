package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

	이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
	
	예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
	
	자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 
	
	input
	1
	10
	13
	100
	1000
	10000
	100000
	0
	
	output
	1
	4
	3
	21
	135
	1033
	8392
	
	Solution : 1. 소수를 판별하는 메소드를 분리하여 while문 이전에 boolean 배열에 배열 T/F를 넣는다.
	 		   2. 소수일 경우 count를 증가시켜주고 for문이 끝난 뒤, 출력해준다.

*/

public class BertrandPostulate {

	public static boolean[] prime = new boolean[246913];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 헤당위치가 소수인지 판별하는 boolean 배열을 만들어준다.
		getPrimeMethod();
		
		while(true) {
			int val = Integer.parseInt(br.readLine());
			int count  = 0;
			
			if(val == 0) break;
			
			for(int i=val+1; i<=2*val; i++) {
				if(!prime[i]) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void getPrimeMethod() {
		// 0과 1은 소수가 아니므로...
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
