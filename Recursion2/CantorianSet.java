package Recursion2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.
	전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.
	
	1. -가 3N개 있는 문자열에서 시작한다.
	2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
	3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
	
	예를 들어, N=3인 경우, 길이가 27인 문자열로 시작한다.
	---------------------------
	여기서 가운데 문자열을 공백으로 바꾼다.
	---------         ---------
	남은 두 선의 가운데 문자열을 공백으로 바꾼다.
	---   ---         ---   ---
	한번 더
	- -   - -         - -   - -
	모든 선의 길이가 1이면 멈춘다. N이 주어졌을 때, 마지막 과정이 끝난 후 결과를 출력하는 프로그램을 작성하시오.

	input			 
	0
	1
	3
	2
	
	output
	-
	- -
	- -   - -         - -   - -
	- -   - -
	
	Solution : 1. 재귀를 이용하여 푸는 문제
			   2. 3등분을 한 다음에는 앞선 3등분의 앞쪽과 뒷쪽을 계속 재귀로 돌린다.
			   3. StringBuilder를 쓰지 않고, print를 사용할 경우 시간초과 이슈가 있다.
			   4. 전체를 채운다음에 공백을 추가하는 문제이다.

*/

public class CantorianSet {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null) {
			int num = Integer.parseInt(str);
			sb = new StringBuilder();
			int length = (int)Math.pow(3, num);
			for(int i=0; i<length; i++) {
				sb.append("-");
			}
			
			minusMethod(0, length);

			System.out.println(sb.toString());
		}
	}
	
	private static void minusMethod(int start, int length) {
		if(length == 1) return;
		
		int len = (length / 3);
		for(int i=start + len; i<(len*2) + start; i++) {
			sb.setCharAt(i, ' ');
		}
		
		minusMethod(start, len); // 3등분 중 앞부분
		minusMethod((len*2) + start, len); // 3등분 중 뒷부분
	}

}
