package Arithmetic;

import java.util.*;
import java.io.*;

/*
	Question : 월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며, 
	한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.
	예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.
	노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다. 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
	A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.

	input			 
	1000 70 170
	
	output
	11
	
	Solution : 말이 어렵지만.. 논리는 생각보다 간단하다.
			   일단, -1이 되는 조건은 2번째 숫자가 3번째 숫자보다 크거나 같을 경우에는 계산이 되지 않으므로 -1로 리턴한다.
			   그렇지 않을 경우에는, 판매금액 - 제작금액 비용으로 전체를 나눈다. 그리고 +1을 해준 것 만큼이 손익 분기점이 된다.
	 
*/

public class BEP {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int found = Integer.parseInt(sc.nextToken());
		int make = Integer.parseInt(sc.nextToken());
		int sell = Integer.parseInt(sc.nextToken());
		
		if(sell <= make) {
			System.out.println(-1);
		} else {
			System.out.println((found / (sell - make)) + 1);
		}
	}
}