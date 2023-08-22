package Arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	
	Solution : 1. 대각선 기준 분수 누적합을 구하여 맞는 범위에서 탐색한다.
			   2. 홀수 기준으로는 분모가 증가하고 분자가 감소하는 로직.
			   3. 짝수 기준으로는 분모가 감소하고 분자가 증가하는 로직.
			   4. 각 기준은 최저값은 무조건 1 / 최댓값은 라인의 최댓값으로 규정
			   5. 대각선에 위치하는 개수는 다음 대각선으로 넘어갈 떄 +1 해준다.
			   
*/

public class FindFraction {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cross_count = 1; // 대각선에 위치하는 개수 => 다음 대각선으로 넘어갈 경우 + 1
		int prev_count_sum = 0;
		
		while (true) {
			if (N <= prev_count_sum + cross_count) {	
				if (cross_count % 2 == 1) {	// 홀수 
					System.out.print((cross_count - (N - prev_count_sum - 1)) + "/" + (N - prev_count_sum));
					break;
				} else { // 짝수
					System.out.print((N - prev_count_sum) + "/" + (cross_count - (N - prev_count_sum - 1)));
					break;
				}
 
			} else {
				prev_count_sum += cross_count;
				cross_count++;
			}
		}
		
	}
}