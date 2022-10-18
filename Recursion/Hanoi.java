package Recursion;

import java.util.*;
import java.io.*;

/*
	Question :	세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.

	한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
	쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
	이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
	
	아래 그림은 원판이 5개인 경우의 예시이다.

	input			 
	3
	
	output
	7
	1 3
	1 2
	3 2
	1 3
	2 1
	2 3
	1 3
	
	Solution : 1. 프로그래머스에서도 접했던 문제
			   2. 하노이 함수 호출될때 count를 추가하여 StringBuilder로 조합하는 것이 차이
			   3. 개념적인 부분은 다시 한번 체크
*/

public class Hanoi {
	
	public static int count = 0;
	public static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Hanoi(n, 1, 2, 3);

		sb.append(count+"\n");
		
		for(int i=0; i<list.size(); i++) {
			if(i <= list.size()-1) sb.append(list.get(i)[0] + " " + list.get(i)[1]+"\n");
			else sb.append(list.get(i)[0] + " " + list.get(i)[1]);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void Hanoi(int n, int start, int mid, int end) {
		count++;
		int[] move = {start, end};
		
		if(n==1) {
			list.add(move);
		} else {
			Hanoi(n-1, start, end, mid);
			
			list.add(move);
			
			Hanoi(n-1, mid, start, end); 
		}
	}
}