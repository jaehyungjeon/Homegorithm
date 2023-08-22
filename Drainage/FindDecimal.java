package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
	
	input			 
	4
	1 3 5 7
	
	output
	3
	
	Solution : 1. 소수란 1과 자기 자신을 제외한 약수가 없는 케이스를 말한다.
			   2. 개수를 받는걸 보니.. 배열을 활용하라는 것 같은데..?
			   3. 1과 자기 자신 즉, cnt가 2일 경우에는 소수이므로 카운트를 증가시켜준다.

*/

public class FindDecimal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		String[] arr = new String[N];
		arr = br.readLine().split(" ");
		
		for(int i=0; i<arr.length; i++) {
			int val = Integer.parseInt(arr[i]);
			if(val == 1) continue;
			else {
				int cnt = 0;
				int idx = 1;
				while(idx <= val) {
					if(val % idx == 0) cnt++;
					
					idx++;
				}
				
				if(cnt == 2) count++;
			}
		}
		
		System.out.println(count);
	}

}
