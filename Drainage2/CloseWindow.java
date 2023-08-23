package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 서강대학교 컴퓨터공학과 실습실 R912호에는 현재 N개의 창문이 있고 또 N명의 사람이 있다. 
	1번째 사람은 1의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다.  2번째 사람은 2의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다. 
	이러한 행동을 N번째 사람까지 진행한 후 열려 있는 창문의 개수를 구하라. 단, 처음에 모든 창문은 닫혀 있다.

	예를 들어 현재 3개의 창문이 있고 3명의 사람이 있을 때,
	
	1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1)
	2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1)
	3번째 사람은 3의 배수인 3번 창문을 닫는다. (1, 0, 0)
	결과적으로 마지막에 열려 있는 창문의 개수는 1개 이다.
	
	input
	3
	-----
	24
	
	output
	1
	-----
	4
	
	Solution : 1. 제곱수만 카운트 해주면 값과 일치한다.

*/

public class CloseWindow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
        for(int i = 1; i * i <= N; i++) {
            count++;
        }
        
		System.out.println(count);
	}

}