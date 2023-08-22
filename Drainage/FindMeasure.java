package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다. 

	6을 예로 들면
	
	6 ÷ 1 = 6 … 0
	6 ÷ 2 = 3 … 0
	6 ÷ 3 = 2 … 0
	6 ÷ 4 = 1 … 2
	6 ÷ 5 = 1 … 1
	6 ÷ 6 = 1 … 0
	그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.
	
	두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
	
	input			 
	6 3
	----------
	25 4
	----------
	2735 1
	
	output
	3
	----------
	0
	----------
	1
	
	Solution : 1. while문을 활용하는게 좋을듯..?
			   2. list를 활용하여 인덱스마다 나눈 값을 넣어준다.
			   3. 리스트 사이즈보다 탐색하려는 인덱스가 클 경우에는 0을 반환하도록 한다.
	   
*/

public class FindMeasure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int idx = 1;
		
		while(idx <= N) {
			if(N%idx == 0) {
				list.add(idx);
			}
			
			idx++;
		}
		
		if(list.size() >= M) {
			System.out.println(list.get(M-1));
		} else {
			System.out.println(0);
		}
	}

}
