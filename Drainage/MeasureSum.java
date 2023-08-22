package Drainage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
	Question : 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.

	예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
	
	n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
	
	input			 
	6
	12
	28
	-1
	
	output
	6 = 1 + 2 + 3
	12 is NOT perfect.
	28 = 1 + 2 + 4 + 7 + 14
	
	Solution : 1. 약수를 먼저 담아준다.
			   2. -1이 들어오면 while문을 break 시켜준다.
			   3. idx로 나눈 나머지들을 담는 리스트를 하나 구성한다.
			   4. 완전수일 경우와 아닐 경우의 분기처리를 해준다.
			   5. 마지막이 되기 전에 +를 해주어야 하므로 for문을 안쪽에 넣고 인덱스를 비교하여 builder에 담아준다.
   
*/

public class MeasureSum {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == -1) { // -1이 오면 break로 반복문 탈출
				break;
			}
			
			int idx = 1;
			int sum = 0; // 약수들의 합을 담아주는 sum변수
			List<Integer> measureList = new ArrayList<Integer>();
			
			while(idx < N) {
				if(N%idx == 0) { // 약수를 담아주는 리스트
					measureList.add(idx);
					sum += idx;
				}
				idx++;
			}
			
			if(sum == N) {
				sb.append(N + " = ");
				for(int i=0; i<measureList.size(); i++) {
					sb.append(measureList.get(i));
					if(i != measureList.size() - 1) {
						sb.append(" + ");
					}
				}
			} else {
				sb.append(N + " is NOT perfect.");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
