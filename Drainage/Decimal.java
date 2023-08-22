package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

	예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
	
	input			 
	60
	100
	
	output
	620
	61
	
	Solution : 1. 소수일 때 min은 Math.min을 활용하여 최솟값을 구해주었다.
			   2. 소수가 없는 경우, 즉 min값이 MAX_VALUE 초기값과 동일할 경우에는 -1을 리턴하도록 하였다.

*/

public class Decimal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=start; i<=end; i++) {
			int idx = 1;
			int count = 0;
			while(idx <= i) {
				if(i%idx == 0) count++;
				idx++;
			}
			
			if(count == 2) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			sb.append(sum + "\n" + min);
			
			System.out.println(sb.toString());
		}
		
	}

}
