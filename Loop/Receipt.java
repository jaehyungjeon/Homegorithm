package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다. 
	그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다! 준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.

	영수증에 적힌,
	
	구매한 각 물건의 가격과 개수
	구매한 물건들의 총 금액
	을 보고, 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.

	input			 
	260000
	4
	20000 5
	30000 2
	10000 6
	5000 8
	
	output
	Yes
	
	Solution : 전체 비용과 같으면 Yes 아니면 No
*/

public class Receipt {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long tot_cost = Long.parseLong(br.readLine());
		
		int count = Integer.parseInt(br.readLine());
		
		long cost = 0;
		for(int i=0; i<count; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			cost += Long.parseLong(sc.nextToken()) * Long.parseLong(sc.nextToken());
		}
		
		if(cost == tot_cost) bw.append("Yes");
		else bw.append("No");
		
		bw.flush();
		bw.close();
		br.close();
	}
}