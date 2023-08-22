package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 4 × 3 = 12이다.

	이 식을 통해 다음과 같은 사실을 알 수 있다.
	
	3은 12의 약수이고, 12는 3의 배수이다.
	
	4도 12의 약수이고, 12는 4의 배수이다.
	
	두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
	
	첫 번째 숫자가 두 번째 숫자의 약수이다.
	첫 번째 숫자가 두 번째 숫자의 배수이다.
	첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
	
	input			 
	8 16
	32 4
	17 5
	0 0
	
	output
	factor
	multiple
	neither
	
	Solution : 1. 두 숫자를 비교하여 큰것과 작은것을 비교해준다.
	 		   2. 나머지가 없으면 약수 or 배수
	 		   3. 0 0 이 들어오면 break 처리 해준다.
		   
*/

public class DrainageMeasure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) {
				break;
			}
			
			if(N > M) {
				if(N%M == 0) {
					sb.append("multiple");
				} else {
					sb.append("neither");
				}
			} else {
				if(M%N == 0) {
					sb.append("factor");
				} else {
					sb.append("neither");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
